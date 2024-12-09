package org.example.service;

import lombok.NoArgsConstructor;
import org.example.entity.Schedule;
import org.example.entity.User;
import org.example.repository.UserRepository;

import java.util.List;

@NoArgsConstructor(force = true)
public class UserService {
  private final UserRepository userRepository;
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public List<User> getUser() {
        return userRepository.findAll();
    }

}
