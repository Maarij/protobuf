package com.example.server.metadata;

import io.grpc.*;

import java.util.Objects;

public class AuthInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall,
                                                                 Metadata metadata,
                                                                 ServerCallHandler<ReqT, RespT> serverCallHandler) {
        String clientToken = metadata.get(ServerConstants.TOKEN);

        if (this.validate(clientToken)) {
            serverCallHandler.startCall(serverCall, metadata);
        } else {
            Status status = Status.UNAUTHENTICATED.withDescription("invalid token");
            serverCall.close(status, metadata);
        }

        return new ServerCall.Listener<>() {};
    }

    private boolean validate(String token) {
        return Objects.nonNull(token) && token.equals("bank-client-sercret");
    }
}
