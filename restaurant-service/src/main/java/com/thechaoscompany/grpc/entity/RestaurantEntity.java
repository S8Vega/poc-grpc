package com.thechaoscompany.grpc.entity;

import com.thechaoscompany.grpc.Dish;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Transient
    private List<String> dishes;

    public void addDishes(List<Dish.DishGrpc> dishesGrpc) {
        List<String> dishes = new ArrayList<>();
        for (Dish.DishGrpc dishGrpc : dishesGrpc) {
            dishes.add(dishGrpc.getName());
        }
        this.dishes = dishes;
    }
}
