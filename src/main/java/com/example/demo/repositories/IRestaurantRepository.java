package com.example.demo.repositories;

import com.example.demo.entities.Restaurant;

public interface IRestaurantRepository extends ICrudRepository<Restaurant, Integer> {
    Restaurant updateRating(Integer restaurantId, Double rating);
}
