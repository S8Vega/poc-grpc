package com.thechaoscompany.dish.service;

import com.thechaoscompany.dish.model.DishModel;
import com.thechaoscompany.dish.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DishService {
    @Autowired
    private DishRepository repository;

    public void save(DishModel dishModel) {
        dishModel.setCreationDate(LocalDateTime.now());
        repository.save(dishModel);
    }

    public List<DishModel> getAll() {
        return repository.findAll();
    }

    public List<DishModel> findByRestaurantId(Long restaurantId) {
        return repository.findByRestaurantId(restaurantId);
    }
}
