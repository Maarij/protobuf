package com.example.protobuf;

import com.example.models.Address;
import com.example.models.Car;
import com.example.models.Person;

public class CompositionDemo {

    public static void main(String[] args) {
        Address address = Address.newBuilder()
                .setPostbox(123)
                .setStreet("main street")
                .setCity("Atlanta")
                .build();

        Car car = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(2020)
                .build();

        Person sam = Person.newBuilder()
                .setName("sam")
                .setAge(25)
                .setCar(car)
                .setAddress(address)
                .build();

        System.out.println(sam);

    }
}
