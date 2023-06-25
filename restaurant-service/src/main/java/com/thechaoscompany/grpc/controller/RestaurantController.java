package com.thechaoscompany.grpc.controller;

import com.thechaoscompany.grpc.entity.RestaurantEntity;
import com.thechaoscompany.grpc.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService service;

    @PostMapping
    public ResponseEntity<RestaurantEntity> save(@RequestBody RestaurantEntity restaurant) {
        RestaurantEntity newRestaurant = service.save(restaurant);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantEntity>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
