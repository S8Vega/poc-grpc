package com.thechaoscompany.dish.grpc;

import com.thechaoscompany.dish.Dish;
import com.thechaoscompany.dish.DishServiceGrpc;
import com.thechaoscompany.dish.service.DishService;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class DishGrpc extends DishServiceGrpc.DishServiceImplBase {
    @Autowired
    private DishService service;

    @Override
    public void save(Dish.SaveDishRequest request, StreamObserver<Dish.SaveDishResponse> responseObserver) {
        com.thechaoscompany.dish.model.Dish dish = com.thechaoscompany.dish.model.Dish.builder()
                .name(request.getName())
                .restaurantId(request.getRestaurantId())
                .build();
        service.save(dish);
        responseObserver.onNext(Dish.SaveDishResponse.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
