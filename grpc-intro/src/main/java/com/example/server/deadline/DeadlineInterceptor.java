package com.example.server.deadline;

import io.grpc.*;

import java.util.concurrent.TimeUnit;

public class DeadlineInterceptor implements ClientInterceptor {

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor,
                                                               CallOptions callOptions,
                                                               Channel channel) {
        return channel.newCall(methodDescriptor, callOptions.withDeadlineAfter(4, TimeUnit.SECONDS));
    }
}