package com.thechaoscompany.dish.model;

import com.thechaoscompany.dish.Dish;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Document(collection = "dishes")
public class DishModel {
    @Id
    private String id;
    private LocalDateTime creationDate;
    private String name;
    private Long restaurantId;

    public static Dish.DishList toDishList(List<DishModel> dishes) {
        List<Dish.DishGrpc> dishesGrpc = new ArrayList<>();
        for (DishModel dish : dishes) {
            dishesGrpc.add(dish.toDishGrpc());
        }
        return Dish.DishList.newBuilder()
                .addAllDishes(dishesGrpc)
                .build();
    }

    public Dish.DishGrpc toDishGrpc() {
        return Dish.DishGrpc.newBuilder()
                .setId(id)
                .setCreationDate(creationDate.toString())
                .setName(name)
                .setRestaurantId(restaurantId)
                .build();
    }
}
