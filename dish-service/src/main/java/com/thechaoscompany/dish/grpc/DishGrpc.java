package com.thechaoscompany.dish.grpc;

import com.thechaoscompany.dish.Dish;
import com.thechaoscompany.dish.DishServiceGrpc;
import com.thechaoscompany.dish.model.DishModel;
import com.thechaoscompany.dish.service.DishService;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@GRpcService
public class DishGrpc extends DishServiceGrpc.DishServiceImplBase {
    @Autowired
    private DishService service;

    @Override
    public void save(Dish.SaveDishRequest request, StreamObserver<Dish.Void> responseObserver) {
        DishModel dishModel = DishModel.builder()
                .name(request.getName())
                .restaurantId(request.getRestaurantId())
                .build();
        service.save(dishModel);
        responseObserver.onNext(Dish.Void.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void getAll(Dish.Void request, StreamObserver<Dish.DishList> responseObserver) {
        List<DishModel> dishes = service.getAll();
        responseObserver.onNext(DishModel.toDishList(dishes));
        responseObserver.onCompleted();
    }

    @Override
    public void findByRestaurantId(Dish.FindByRestaurantIdRequest request, StreamObserver<Dish.DishList> responseObserver) {
        List<DishModel> dishes = service.findByRestaurantId(request.getRestaurantId());
        responseObserver.onNext(DishModel.toDishList(dishes));
        responseObserver.onCompleted();
    }
}
