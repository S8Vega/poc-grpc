package com.thechaoscompany.dish.repository;

import com.thechaoscompany.dish.model.DishModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DishRepository extends MongoRepository<DishModel, String> {
    List<DishModel> findByRestaurantId(Long restaurantId);
}