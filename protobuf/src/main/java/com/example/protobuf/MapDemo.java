package com.example.protobuf;

import com.example.models.Car;
import com.example.models.Dealer;

public class MapDemo {

    public static void main(String[] args) {
        Car accord = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(2020)
                .build();

        Car civic = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setYear(2005)
                .build();

        Dealer dealer = Dealer.newBuilder()
                .putModel(2005, civic)
                .putModel(2020, accord)
                .build();

        System.out.println(dealer.getModelOrDefault(2019, accord));
        System.out.println(dealer.getModelMap());

    }
}