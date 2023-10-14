package com.example.protobuf;

import com.example.models.Person;

public class PersonDemo {

    public static void main(String[] args) {
        Person sam = Person.newBuilder()
                .setName("sam")
                .setAge(10)
                .build();

        System.out.println(sam);
    }
}
