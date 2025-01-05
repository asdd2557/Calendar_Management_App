package org.example.repository;

import org.example.dto.ScheduleDeleteRequestDto;
import org.example.dto.SchedulePutRequestDTO;
import org.example.entity.Schedule;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Schedule> findSchedulesByPeriod(LocalDateTime startDateTime, LocalDateTime endDateTime, String userName) {
        StringBuilder sql = new StringBuilder("SELECT * FROM Schedule WHERE 1=1");

        List<Object> params = new ArrayList<>();

        if (startDateTime != null) {
            sql.append(" AND update_date_time >= ?");
            params.add(startDateTime);
        }

        if (endDateTime != null) {
            sql.append(" AND update_date_time <= ?");
            params.add(endDateTime);
        }

        if (userName != null) {
            sql.append(" AND user_name = ?");
            params.add(userName);
        }

        sql.append(" ORDER BY update_date_time DESC");

        return jdbcTemplate.query(sql.toString(), params.toArray(), new ScheduleRowMapper());
    }

    @Override
    public void save(Schedule schedule) {
        String sql = "INSERT INTO Schedule (user_name, description, password, start_date_time, update_date_time) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                schedule.getUserName(),
                schedule.getDescription(),
                schedule.getPassword(),
                schedule.getStartDateTime(),
                schedule.getUpdateDateTime()
        );
    }

    @Override
    public void update(Long id, SchedulePutRequestDTO requestDTO) {
        // 비밀번호 확인
        validatePassword(id, requestDTO.getPassword());

        // 업데이트 실행
        String updateSql = "UPDATE Schedule SET description = ?, update_date_time = ? WHERE id = ?";
        LocalDateTime updateTime =  LocalDateTime.now();

        jdbcTemplate.update(updateSql,
                requestDTO.getContents(), // DTO에서 description 값 추출
                updateTime,               // DTO에서 전달받은 수정 시간
                id                        // ID
        );
    }

    @Override
    public void deleteById(Long id, ScheduleDeleteRequestDto requestDto) {
        // 비밀번호 확인
        validatePassword(id, requestDto.getPassword());

        // 삭제 실행
        String deleteSql = "DELETE FROM Schedule WHERE id = ?";
        jdbcTemplate.update(deleteSql, id);
    }

    public void deleteAll() {
        String sql = "DELETE FROM Schedule";
        jdbcTemplate.update(sql);
    }

    @Override
    public List<Schedule> findAll() {
        String sql = "SELECT * FROM Schedule";
        return jdbcTemplate.query(sql, new ScheduleRowMapper());
    }

    /**
     * 비밀번호 확인 메서드
     *
     * @param id       대상 ID
     * @param password 입력된 비밀번호
     */
    private void validatePassword(Long id, String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("비밀번호는 비어 있을 수 없습니다.");
        }

        String passwordCheckSql = "SELECT password FROM Schedule WHERE id = ?";
        String existingPassword;

        try {
            existingPassword = jdbcTemplate.queryForObject(passwordCheckSql, new Object[]{id}, String.class);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("해당 ID에 대한 데이터가 없습니다.");
        }

        if (!existingPassword.equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

    private static class ScheduleRowMapper implements RowMapper<Schedule> {
        @Override
        public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
            Schedule schedule = new Schedule();
            schedule.setId(rs.getLong("id"));
            schedule.setUserName(rs.getString("user_name"));
            schedule.setDescription(rs.getString("description"));
            schedule.setPassword(rs.getString("password"));
            schedule.setStartDateTime(rs.getTimestamp("start_date_time").toLocalDateTime());
            schedule.setUpdateDateTime(rs.getTimestamp("update_date_time").toLocalDateTime());
            return schedule;
        }
    }
}
