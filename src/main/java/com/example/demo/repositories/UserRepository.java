package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.User;

public class UserRepository implements IUserRepository {

    private Map<Integer, User> userMap;
    private int autoIncrement;

    public UserRepository() {
        this.userMap = new HashMap<Integer, User>();
        this.autoIncrement = 1;
    }

    @Override
    public User save(User entity) {
        User u = new User(autoIncrement, entity.getName());
        userMap.put(autoIncrement, u);
        ++autoIncrement;
        return u;
    }

    @Override
    public void deleteById(Integer id) {
        userMap.remove(id);
    }

    @Override
    public List<User> findAll() {
        if(userMap.isEmpty()) return new ArrayList<>();

        return userMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(userMap.get(id));
    }

    
    
}
