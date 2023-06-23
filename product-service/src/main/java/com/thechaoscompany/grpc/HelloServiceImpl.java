package com.thechaoscompany.grpc;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase{
    @Override
    public void sayHello(Hello.HelloRequest request, StreamObserver<Hello.HelloResponse> responseObserver) {
        String name = request.getName();
        String message = "Hello, " + name + "!";
        Hello.HelloResponse response = Hello.HelloResponse.newBuilder().setMessage(message).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
