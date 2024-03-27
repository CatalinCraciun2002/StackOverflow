package com.example.stackoverflow.service;

import com.example.stackoverflow.entity.User;
import com.example.stackoverflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User findById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public User findByUserName(String userName) {
        return this.userRepository.findByUserName(userName).orElse(null);
    }

    public List<User> retrieveUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    public User insertUser(User user) {
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return this.userRepository.save(user);
    }

    public User updateUser(User user) {
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return this.userRepository.save(user);
    }

    public String deleteById(Long id) {
        try {
            this.userRepository.deleteById(id);
            return "User deleted successfully.";
        } catch (Exception e) {
            return "Failed to delete user with id " + id;
        }
    }
}
