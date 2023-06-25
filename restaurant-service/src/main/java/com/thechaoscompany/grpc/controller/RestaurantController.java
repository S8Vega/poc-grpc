package com.thechaoscompany.grpc.controller;

import com.thechaoscompany.grpc.entity.RestaurantEntity;
import com.thechaoscompany.grpc.service.RestaurantService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<RestaurantEntity> save(@RequestBody @NotNull SaveRestaurantRequest request) {
        RestaurantEntity restaurant = service.save(request.toRestaurantEntity());
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantEntity>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
