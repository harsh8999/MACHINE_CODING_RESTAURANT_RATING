package com.example.demo.entities;

public class Review {
    
    private Integer id;
    private User user;
    private Restaurant restaurant;
    private Double rating;
    private String dishes;
    private String description;
    
    public Review(Integer id, User user, Restaurant restaurant, Double rating, String dishes,
            String description) {
        this.id = id;
        this.user = user;
        this.restaurant = restaurant;
        this.rating = rating;
        this.dishes = dishes;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public String getDishes() {
        return dishes;
    }

    public String getDescription() {
        return description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review [id=" + id + "]";
    }

    
    
}
