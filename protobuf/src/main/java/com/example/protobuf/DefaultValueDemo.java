package com.example.protobuf;

import com.example.models.Person;

public class DefaultValueDemo {

    public static void main(String[] args) {
        Person person = Person.newBuilder().build();

        System.out.println("City: " + person.getAddress().getCity()); // No concept of null
        System.out.println(person.hasAddress()); // generated for non-primitive types
    }
}
