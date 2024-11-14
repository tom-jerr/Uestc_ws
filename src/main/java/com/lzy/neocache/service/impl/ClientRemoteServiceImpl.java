package com.lzy.neocache.service.impl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import com.lzy.neocache.utils.grpc.*;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * grpc客户端服务:
 * 1. docker中运行时用容器name作地址
 * 2. 本地单独中运行时用localhost
 *
 * @author lzy 
 */
@Service
public class ClientRemoteServiceImpl {
    private ConcurrentHashMap<String, ManagedChannel> cacheChannel;

    public ClientRemoteServiceImpl() {
        this.cacheChannel = new ConcurrentHashMap<String, ManagedChannel>();
    }

    private ManagedChannel getChannel(String serverAddress, int port) {
        if (cacheChannel.isEmpty()) {
            ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, port + 10)
                    .usePlaintext()
                    .build();
            cacheChannel.put(serverAddress + (port + 10), channel);
            return channel;
        } else {
            ManagedChannel cachedChannel = cacheChannel.computeIfAbsent(serverAddress + (port + 10), key -> ManagedChannelBuilder.forAddress(serverAddress, port + 10)
                    .usePlaintext()
                    .build());
            if (cachedChannel.isShutdown()) {
                return ManagedChannelBuilder.forAddress(serverAddress, port + 10)
                        .usePlaintext()
                        .build();
            }
            return cachedChannel;
        }
    }

    @PreDestroy
    public void onShutdown() {
        cacheChannel.values().forEach(value -> value.shutdown());
        cacheChannel.clear();
    }

    /**
     * 调用远程函数删除kv
     *
     * @param serverAddress 远程服务器name
     * @param port          远程服务器grpc端口
     * @param key           删除的key值
     * @return 删除成功为true
     */
    public boolean doDeleteRemote(String serverAddress, int port, String key) {
        // String serverAddress = "localhost";
        ManagedChannel channel = getChannel(serverAddress, port);

        RemoteServiceGrpc.RemoteServiceBlockingStub stub = RemoteServiceGrpc.newBlockingStub(channel);

        // 调用 gRPC 服务
        RemoteRequest putRequest = RemoteRequest.newBuilder()
                .setKey(key)
                .build();
        RemoteResponse delete = stub.delete(putRequest);
        if (!delete.hasValue()) {
            return false;
        }
        return true;
    }

    /**
     * 调用远程函数添加kv
     *
     * @param serverAddress
     * @param port
     * @param key
     * @param value
     * @param nodeNo
     * @return 添加成功为true
     */
	@SuppressWarnings("unchecked")
	public boolean doAddRemote(String serverAddress, int port, String key, Object value) {
        ManagedChannel channel = getChannel(serverAddress, port);
        RemoteServiceGrpc.RemoteServiceBlockingStub stub = RemoteServiceGrpc.newBlockingStub(channel);

        Data data;
        if (value instanceof ArrayList<?>) {
            ArrayString.Builder arrayStringBuilder = ArrayString.newBuilder();
            ArrayList<String> stringList = (ArrayList<String>) value;
            data = Data.newBuilder().setArrayString(arrayStringBuilder.addAllStringArray(stringList)).build();
        } else {
            data = Data.newBuilder().setString((String) value).build();
        }

        RemoteRequest putRequest = RemoteRequest.newBuilder()
                .setKey(key)
                .setValue(data)
                .build();
        stub.add(putRequest);

        return true;
    }

    public Object doGetRemote(String serverAddress, int port, String key) {
        ManagedChannel channel = getChannel(serverAddress, port);
        RemoteServiceGrpc.RemoteServiceBlockingStub stub = RemoteServiceGrpc.newBlockingStub(channel);
        RemoteRequest putRequest = RemoteRequest.newBuilder()
                .setKey(key)
                .build();
        RemoteResponse get = stub.get(putRequest);
        if (!get.hasValue()) {
            return null;
        }
        return get.getValue();
    }
}
