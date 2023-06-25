package com.thechaoscompany.grpc.repository;

import com.thechaoscompany.grpc.model.DishModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DishRepository extends MongoRepository<DishModel, String> {
    List<DishModel> findByRestaurantId(Long restaurantId);
}