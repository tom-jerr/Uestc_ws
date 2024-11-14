package com.lzy.neocache.service.impl;


import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import com.lzy.neocache.entity.Cache;
import com.lzy.neocache.utils.grpc.*;

import java.util.ArrayList;

@GrpcService
public class ServerRemoteServiceImpl extends RemoteServiceGrpc.RemoteServiceImplBase {
    @Autowired
    private Cache cacheNodes;

    @SuppressWarnings("unchecked")
    @Override
    public void get(RemoteRequest request, StreamObserver<RemoteResponse> responseObserver) {
        Object element = cacheNodes.getElement(request.getKey());
        if (element == null) {
            responseObserver.onNext(null);
            responseObserver.onCompleted();
            return;
        }
        RemoteResponse response;
        if (element instanceof ArrayList<?>) {
            ArrayString.Builder arrayStringBuilder = ArrayString.newBuilder();
            ArrayList<String> stringList = (ArrayList<String>) element;
            response = RemoteResponse.newBuilder().
                    setValue(Data.newBuilder().setArrayString(arrayStringBuilder.addAllStringArray(stringList))).build();
        } else {
            response = RemoteResponse.newBuilder().setValue(Data.newBuilder().setString((String) element).build()).build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void add(RemoteRequest request, StreamObserver<RemoteResponse> responseObserver) {
        Data requestValue = request.getValue();
        Object value;
        if (requestValue.hasArrayString()) {
            value = requestValue.getArrayString().getStringArrayList().stream().toList();
        } else {
            value = requestValue.getString();
        }
        cacheNodes.addElement(request.getKey(), value);
        RemoteResponse response = RemoteResponse.newBuilder().setValue(Data.newBuilder().setString("1")).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(RemoteRequest request, StreamObserver<RemoteResponse> responseObserver) {
        if (cacheNodes.removeElement(request.getKey())) {
            RemoteResponse response = RemoteResponse.newBuilder().setValue(Data.newBuilder().setString("1")).build();
            responseObserver.onNext(response);
        } else {
            responseObserver.onNext(null);
        }
        responseObserver.onCompleted();
    }
}