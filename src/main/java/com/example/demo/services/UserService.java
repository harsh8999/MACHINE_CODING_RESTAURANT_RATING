package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.User;
import com.example.demo.repositories.IUserRepository;

public class UserService {
    
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(String name) {
        User user = new User(null, name);
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id: " + id + " not found!"));
    }

}
