package com.thechaoscompany.dish.repository;

import com.thechaoscompany.dish.model.Dish;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DishRepository extends MongoRepository<Dish, String> {
    List<Dish> findByRestaurantId(Long restaurantId);
}