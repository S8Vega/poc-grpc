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

    public RestaurantEntity save(RestaurantEntity restaurant) {
        return repository.save(restaurant);
    }

    public List<RestaurantEntity> getAll() {
        return (List<RestaurantEntity>) repository.findAll();
    }
}
