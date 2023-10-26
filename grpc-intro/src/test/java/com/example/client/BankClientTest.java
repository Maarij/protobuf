package com.example.client;

import com.example.models.Balance;
import com.example.models.BalanceCheckRequest;
import com.example.models.BankServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankClientTest {

    private BankServiceGrpc.BankServiceBlockingStub blockingStub;

    @BeforeAll
    public void setup() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();

        this.blockingStub = BankServiceGrpc.newBlockingStub(managedChannel);
    }

    @Test
    public void balanceTest() {
        BalanceCheckRequest balanceRequest = BalanceCheckRequest.newBuilder()
                .setAccountNumber(7)
                .build();

        // Send request and wait for response (synchronous)
        Balance balance = this.blockingStub.getBalance(balanceRequest);

        System.out.println("Received: " + balance.getAmount());
    }

}
