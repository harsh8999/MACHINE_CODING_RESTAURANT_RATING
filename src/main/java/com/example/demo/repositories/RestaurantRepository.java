package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;

public class RestaurantRepository implements IRestaurantRepository {

    private Map<Integer, Restaurant> restaurantMap;
    private Integer autoIncrement;

    public RestaurantRepository() {
        this.restaurantMap = new HashMap<>();
        autoIncrement = 1;
    }

    @Override
    public Restaurant save(Restaurant entity) {
        Restaurant r = new Restaurant(autoIncrement, entity.getName());
        restaurantMap.put(autoIncrement, r);
        ++autoIncrement;
        return r;
    }

    @Override
    public Optional<Restaurant> findById(Integer id) {
        return Optional.ofNullable(restaurantMap.get(id));
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        restaurantMap.remove(id);
    }

    @Override
    public Restaurant updateRating(Integer restaurantId, Double rating) {
        Restaurant restaurant = restaurantMap.get(restaurantId);
        restaurant.setRating(rating);
        return restaurant;
    }
    
}
