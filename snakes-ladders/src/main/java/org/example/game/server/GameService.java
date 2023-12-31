package org.example.game.server;

import com.example.game.Die;
import com.example.game.GameServiceGrpc;
import com.example.game.GameState;
import com.example.game.Player;
import io.grpc.stub.StreamObserver;

public class GameService extends GameServiceGrpc.GameServiceImplBase {

    @Override
    public StreamObserver<Die> roll(StreamObserver<GameState> responseObserver) {
        Player client = Player.newBuilder().setName("client").setPosition(0).build();
        Player server = Player.newBuilder().setName("server").setPosition(0).build();

        return new DieStreamingRequest(client, server, responseObserver);
    }
}
