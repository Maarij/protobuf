package com.example.protobuf;

import com.example.models.Address;
import com.example.models.Car;
import com.example.models.Person;

import java.util.List;

public class CompositionDemo {

    public static void main(String[] args) {
        Address address = Address.newBuilder()
                .setPostbox(123)
                .setStreet("main street")
                .setCity("Atlanta")
                .build();

        Car accord = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(2020)
                .build();

        Car civic = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setYear(2020)
                .build();

        List<Car> cars = List.of(accord, civic);

        Person sam = Person.newBuilder()
                .setName("sam")
                .setAge(25)
                .addAllCar(cars)
                .setAddress(address)
                .build();

        System.out.println(sam);

    }
}
