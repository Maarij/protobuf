package com.example.client.metadata;

import io.grpc.Metadata;

public class ClientConstants {

    public static final Metadata METADATA = new Metadata();

    static {
        METADATA.put(
                Metadata.Key.of("client-token", Metadata.ASCII_STRING_MARSHALLER),
                "bank-client-secre"
        );
    }

    public static Metadata getClientToken() {
        return METADATA;
    }
}
