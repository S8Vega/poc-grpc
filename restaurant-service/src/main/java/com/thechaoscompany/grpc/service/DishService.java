package com.thechaoscompany.grpc.service;

import com.thechaoscompany.grpc.Dish;
import com.thechaoscompany.grpc.DishServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    private final ManagedChannel channel = NettyChannelBuilder.forTarget("dns:///localhost:6565")
            .usePlaintext().build();

    public List<Dish.DishGrpc> findByRestaurantId(Long restaurantId) {
        DishServiceGrpc.DishServiceBlockingStub stub = DishServiceGrpc.newBlockingStub(channel);
        Dish.DishList dishList = stub.findByRestaurantId(Dish.FindByRestaurantIdRequest.newBuilder()
                .setRestaurantId(restaurantId)
                .build());
        return dishList.getDishesList();
    }
}
