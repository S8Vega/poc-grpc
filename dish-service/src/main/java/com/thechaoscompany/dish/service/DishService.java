package com.thechaoscompany.dish.service;

import com.thechaoscompany.dish.model.Dish;
import com.thechaoscompany.dish.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    @Autowired
    private DishRepository repository;

    public void save(Dish dish) {
        repository.save(dish);
    }

    public List<Dish> getAll() {
        return repository.findAll();
    }

    public List<Dish> findByRestaurantId(Long restaurantId) {
        return repository.findByRestaurantId(restaurantId);
    }
}
