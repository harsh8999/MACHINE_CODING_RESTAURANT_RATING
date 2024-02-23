package com.example.demo.entities;

public class Restaurant {
    
    private Integer id;
    private String name;
    private Double rating;

    public Restaurant(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.rating = 0D;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Restaurant [id=" + id + "]";
    }
    
}
