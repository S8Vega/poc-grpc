package com.thechaoscompany.server.grpcserviceimpl;

import com.thechaoscompany.server.Empty;
import com.thechaoscompany.server.Id;
import com.thechaoscompany.server.SchoolObject;
import com.thechaoscompany.server.SchoolServiceGrpc;
import com.thechaoscompany.server.SchoolsList;
import com.thechaoscompany.server.service.SchoolService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class GrpcSchoolServiceImpl extends SchoolServiceGrpc.SchoolServiceImplBase {
    @Autowired
    private SchoolService schoolService;

    @Override
    public void getOneByID(Id request, StreamObserver<SchoolObject> responseObserver) {
        super.getOneByID(request, responseObserver);
    }

    @Override
    public void getAll(Empty request, StreamObserver<SchoolsList> responseObserver) {
        super.getAll(request, responseObserver);
    }
}
