package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Review;

public class ReviewRepositry implements IReviewRepository {
    
    private Map<Integer, Review> reviewMap;
    private int autoIncrement;

    public ReviewRepositry() {
        this.reviewMap = new HashMap<>();
        this.autoIncrement = 1;
    }

    @Override
    public Review save(Review entity) {
        Review r = new Review(autoIncrement, entity.getUser(), entity.getRestaurant(), entity.getRating(),entity.getDishes(), entity.getDescription());
        reviewMap.put(autoIncrement, r);
        ++autoIncrement;
        return r;
    }

    @Override
    public void deleteById(Integer id) {
        reviewMap.remove(id);
    }

    @Override
    public List<Review> findAll() {
        return reviewMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Review> findById(Integer id) {
        return Optional.ofNullable(reviewMap.get(id));
    }
    
}
