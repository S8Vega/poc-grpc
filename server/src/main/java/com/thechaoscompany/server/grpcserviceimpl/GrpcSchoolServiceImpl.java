package com.thechaoscompany.server.grpcserviceimpl;

import com.thechaoscompany.server.Empty;
import com.thechaoscompany.server.Id;
import com.thechaoscompany.server.School;
import com.thechaoscompany.server.SchoolServiceGrpc;
import com.thechaoscompany.server.SchoolsList;
import com.thechaoscompany.server.entities.SchoolEntity;
import com.thechaoscompany.server.service.SchoolService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@GrpcService
public class GrpcSchoolServiceImpl extends SchoolServiceGrpc.SchoolServiceImplBase {
    @Autowired
    private SchoolService schoolervice;

    @Override
    public void getOneByID(Id request, StreamObserver<School> responseObserver) {
        CompletableFuture<SchoolEntity> foundSchool = schoolervice.getOneById(request.getId());
        foundSchool.join();
        School objectSchoolToReturn = School.newBuilder()
                .setId(foundSchool.join().getId())
                .setLocation(foundSchool.join().getLocation())
                .setName(foundSchool.join().getName())
                .setStatus(foundSchool.join().getStatus())
                .build();
        responseObserver.onNext(objectSchoolToReturn);
        responseObserver.onCompleted();
    }

    @Override
    public void getAll(Empty request, StreamObserver<SchoolsList> responseObserver) {
        CompletableFuture<List<SchoolEntity>> completeList = schoolervice.getAll();
        List<School> schoolsGrpcList = new ArrayList<>();
        for (int i = 0; i < completeList.join().size(); i++) {
            School schoolToAdd = School.newBuilder()
                    .setId(completeList.join().get(i).getId())
                    .setLocation(completeList.join().get(i).getLocation())
                    .setName(completeList.join().get(i).getName())
                    .setStatus(completeList.join().get(i).getStatus())
                    .build();

            schoolsGrpcList.add(schoolToAdd);
        }
        SchoolsList.Builder listToReturn = SchoolsList.newBuilder();

        for (School eachSchool : schoolsGrpcList) {
            listToReturn.addSchool(eachSchool);
        }
        responseObserver.onNext(listToReturn.build());
        responseObserver.onCompleted();
    }
}
