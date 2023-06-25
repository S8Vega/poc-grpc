package com.thechaoscompany.grpc.repository;

import com.thechaoscompany.grpc.entity.RestaurantEntity;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<RestaurantEntity, Long> {
}