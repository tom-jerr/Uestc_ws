package com.lzy.neocache.utils.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: RemoteService.proto")
public final class RemoteServiceGrpc {

  private RemoteServiceGrpc() {}

  public static final String SERVICE_NAME = "RemoteService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.lzy.neocache.utils.grpc.RemoteRequest,
      com.lzy.neocache.utils.grpc.RemoteResponse> METHOD_GET = getGetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.lzy.neocache.utils.grpc.RemoteRequest,
      com.lzy.neocache.utils.grpc.RemoteResponse> getGetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.lzy.neocache.utils.grpc.RemoteRequest,
      com.lzy.neocache.utils.grpc.RemoteResponse> getGetMethod() {
    return getGetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.lzy.neocache.utils.grpc.RemoteRequest,
      com.lzy.neocache.utils.grpc.RemoteResponse> getGetMethodHelper() {
    io.grpc.MethodDescriptor<com.lzy.neocache.utils.grpc.RemoteRequest, com.lzy.neocache.utils.grpc.RemoteResponse> getGetMethod;
    if ((getGetMethod = RemoteServiceGrpc.getGetMethod) == null) {
      synchronized (RemoteServiceGrpc.class) {
        if ((getGetMethod = RemoteServiceGrpc.getGetMethod) == null) {
          RemoteServiceGrpc.getGetMethod = getGetMethod = 
              io.grpc.MethodDescriptor.<com.lzy.neocache.utils.grpc.RemoteRequest, com.lzy.neocache.utils.grpc.RemoteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RemoteService", "Get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lzy.neocache.utils.grpc.RemoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lzy.neocache.utils.grpc.RemoteResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RemoteServiceMethodDescriptorSupplier("Get"))
                  .build();
          }
        }
     }
     return getGetMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.lzy.neocache.utils.grpc.RemoteRequest,
      com.lzy.neocache.utils.grpc.RemoteResponse> METHOD_ADD = getAddMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.lzy.neocache.utils.grpc.RemoteRequest,
      com.lzy.neocache.utils.grpc.RemoteResponse> getAddMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.lzy.neocache.utils.grpc.RemoteRequest,
      com.lzy.neocache.utils.grpc.RemoteResponse> getAddMethod() {
    return getAddMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.lzy.neocache.utils.grpc.RemoteRequest,
      com.lzy.neocache.utils.grpc.RemoteResponse> getAddMethodHelper() {
    io.grpc.MethodDescriptor<com.lzy.neocache.utils.grpc.RemoteRequest, com.lzy.neocache.utils.grpc.RemoteResponse> getAddMethod;
    if ((getAddMethod = RemoteServiceGrpc.getAddMethod) == null) {
      synchronized (RemoteServiceGrpc.class) {
        if ((getAddMethod = RemoteServiceGrpc.getAddMethod) == null) {
          RemoteServiceGrpc.getAddMethod = getAddMethod = 
              io.grpc.MethodDescriptor.<com.lzy.neocache.utils.grpc.RemoteRequest, com.lzy.neocache.utils.grpc.RemoteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RemoteService", "Add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lzy.neocache.utils.grpc.RemoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lzy.neocache.utils.grpc.RemoteResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RemoteServiceMethodDescriptorSupplier("Add"))
                  .build();
          }
        }
     }
     return getAddMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.lzy.neocache.utils.grpc.RemoteRequest,
      com.lzy.neocache.utils.grpc.RemoteResponse> METHOD_DELETE = getDeleteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.lzy.neocache.utils.grpc.RemoteRequest,
      com.lzy.neocache.utils.grpc.RemoteResponse> getDeleteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.lzy.neocache.utils.grpc.RemoteRequest,
      com.lzy.neocache.utils.grpc.RemoteResponse> getDeleteMethod() {
    return getDeleteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.lzy.neocache.utils.grpc.RemoteRequest,
      com.lzy.neocache.utils.grpc.RemoteResponse> getDeleteMethodHelper() {
    io.grpc.MethodDescriptor<com.lzy.neocache.utils.grpc.RemoteRequest, com.lzy.neocache.utils.grpc.RemoteResponse> getDeleteMethod;
    if ((getDeleteMethod = RemoteServiceGrpc.getDeleteMethod) == null) {
      synchronized (RemoteServiceGrpc.class) {
        if ((getDeleteMethod = RemoteServiceGrpc.getDeleteMethod) == null) {
          RemoteServiceGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<com.lzy.neocache.utils.grpc.RemoteRequest, com.lzy.neocache.utils.grpc.RemoteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RemoteService", "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lzy.neocache.utils.grpc.RemoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lzy.neocache.utils.grpc.RemoteResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RemoteServiceMethodDescriptorSupplier("Delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RemoteServiceStub newStub(io.grpc.Channel channel) {
    return new RemoteServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RemoteServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RemoteServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RemoteServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RemoteServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class RemoteServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void get(com.lzy.neocache.utils.grpc.RemoteRequest request,
        io.grpc.stub.StreamObserver<com.lzy.neocache.utils.grpc.RemoteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethodHelper(), responseObserver);
    }

    /**
     */
    public void add(com.lzy.neocache.utils.grpc.RemoteRequest request,
        io.grpc.stub.StreamObserver<com.lzy.neocache.utils.grpc.RemoteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddMethodHelper(), responseObserver);
    }

    /**
     */
    public void delete(com.lzy.neocache.utils.grpc.RemoteRequest request,
        io.grpc.stub.StreamObserver<com.lzy.neocache.utils.grpc.RemoteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lzy.neocache.utils.grpc.RemoteRequest,
                com.lzy.neocache.utils.grpc.RemoteResponse>(
                  this, METHODID_GET)))
          .addMethod(
            getAddMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lzy.neocache.utils.grpc.RemoteRequest,
                com.lzy.neocache.utils.grpc.RemoteResponse>(
                  this, METHODID_ADD)))
          .addMethod(
            getDeleteMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lzy.neocache.utils.grpc.RemoteRequest,
                com.lzy.neocache.utils.grpc.RemoteResponse>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class RemoteServiceStub extends io.grpc.stub.AbstractStub<RemoteServiceStub> {
    private RemoteServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RemoteServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RemoteServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RemoteServiceStub(channel, callOptions);
    }

    /**
     */
    public void get(com.lzy.neocache.utils.grpc.RemoteRequest request,
        io.grpc.stub.StreamObserver<com.lzy.neocache.utils.grpc.RemoteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void add(com.lzy.neocache.utils.grpc.RemoteRequest request,
        io.grpc.stub.StreamObserver<com.lzy.neocache.utils.grpc.RemoteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.lzy.neocache.utils.grpc.RemoteRequest request,
        io.grpc.stub.StreamObserver<com.lzy.neocache.utils.grpc.RemoteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RemoteServiceBlockingStub extends io.grpc.stub.AbstractStub<RemoteServiceBlockingStub> {
    private RemoteServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RemoteServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RemoteServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RemoteServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.lzy.neocache.utils.grpc.RemoteResponse get(com.lzy.neocache.utils.grpc.RemoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.lzy.neocache.utils.grpc.RemoteResponse add(com.lzy.neocache.utils.grpc.RemoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.lzy.neocache.utils.grpc.RemoteResponse delete(com.lzy.neocache.utils.grpc.RemoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RemoteServiceFutureStub extends io.grpc.stub.AbstractStub<RemoteServiceFutureStub> {
    private RemoteServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RemoteServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RemoteServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RemoteServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lzy.neocache.utils.grpc.RemoteResponse> get(
        com.lzy.neocache.utils.grpc.RemoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lzy.neocache.utils.grpc.RemoteResponse> add(
        com.lzy.neocache.utils.grpc.RemoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lzy.neocache.utils.grpc.RemoteResponse> delete(
        com.lzy.neocache.utils.grpc.RemoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET = 0;
  private static final int METHODID_ADD = 1;
  private static final int METHODID_DELETE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RemoteServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RemoteServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET:
          serviceImpl.get((com.lzy.neocache.utils.grpc.RemoteRequest) request,
              (io.grpc.stub.StreamObserver<com.lzy.neocache.utils.grpc.RemoteResponse>) responseObserver);
          break;
        case METHODID_ADD:
          serviceImpl.add((com.lzy.neocache.utils.grpc.RemoteRequest) request,
              (io.grpc.stub.StreamObserver<com.lzy.neocache.utils.grpc.RemoteResponse>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.lzy.neocache.utils.grpc.RemoteRequest) request,
              (io.grpc.stub.StreamObserver<com.lzy.neocache.utils.grpc.RemoteResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RemoteServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RemoteServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lzy.neocache.utils.grpc.RemoteServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RemoteService");
    }
  }

  private static final class RemoteServiceFileDescriptorSupplier
      extends RemoteServiceBaseDescriptorSupplier {
    RemoteServiceFileDescriptorSupplier() {}
  }

  private static final class RemoteServiceMethodDescriptorSupplier
      extends RemoteServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RemoteServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RemoteServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RemoteServiceFileDescriptorSupplier())
              .addMethod(getGetMethodHelper())
              .addMethod(getAddMethodHelper())
              .addMethod(getDeleteMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
