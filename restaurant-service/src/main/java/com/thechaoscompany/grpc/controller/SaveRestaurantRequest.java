package com.thechaoscompany.grpc.controller;

import com.thechaoscompany.grpc.entity.RestaurantEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveRestaurantRequest {
    private String name;

    public RestaurantEntity toRestaurantEntity() {
        RestaurantEntity restaurant = new RestaurantEntity();
        restaurant.setName(name);
        return restaurant;
    }
}
