package com.example.springboot_kata.services;

import com.example.springboot_kata.models.User;
import com.example.springboot_kata.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional

    public void addUser(User user) {
        userRepository.save(user);
    }


    @Transactional
    public void removeUser(int id) {
        userRepository.deleteById(id);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User findOne(int id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElse(null);
    }


    @Transactional
    public void update(int id, User updatedUser) {
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }
}