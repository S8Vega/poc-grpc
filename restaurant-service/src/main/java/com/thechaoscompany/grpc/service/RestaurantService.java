package com.thechaoscompany.grpc.service;

import com.thechaoscompany.grpc.entity.RestaurantEntity;
import com.thechaoscompany.grpc.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository repository;
    @Autowired
    private DishService dishService;

    public RestaurantEntity save(RestaurantEntity restaurant) {
        return repository.save(restaurant);
    }

    public List<RestaurantEntity> getAll() {
        List<RestaurantEntity> restaurants = (List<RestaurantEntity>) repository.findAll();
        for (RestaurantEntity restaurant : restaurants) {
            restaurant.addDishes(dishService.findByRestaurantId(restaurant.getId()));
        }
        return restaurants;
    }

    public RestaurantEntity findById(Long id) {
        RestaurantEntity restaurant = repository.findById(id).orElseThrow();
        restaurant.addDishes(dishService.findByRestaurantId(id));
        return restaurant;
    }
}
