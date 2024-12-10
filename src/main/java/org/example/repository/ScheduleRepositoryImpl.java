package org.example.repository;

import org.example.entity.Schedule;
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
    public void update(Long id, Schedule schedule) {
        String sql = "UPDATE Schedule SET user_name = ?, description = ?, update_date_time = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                schedule.getUserName(),
                schedule.getDescription(),
                schedule.getUpdateDateTime(),
                id
        );
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM Schedule WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    public void deleteAll(){
        String sql = "DELETE FROM Schedule";
        jdbcTemplate.update(sql);
    }

    @Override
    public List<Schedule> findAll() {
        String sql = "SELECT * FROM Schedule";
        return jdbcTemplate.query(sql, new ScheduleRowMapper());
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
