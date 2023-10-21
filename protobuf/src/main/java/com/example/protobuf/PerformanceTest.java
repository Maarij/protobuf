package com.example.protobuf;

import com.example.json.JPerson;
import com.example.models.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PerformanceTest {

    public static void main(String[] args) {

        // json
        JPerson person = new JPerson();
        person.setName("sam");
        person.setAge(10);
        ObjectMapper mapper = new ObjectMapper();
        Runnable json = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(person);
                // System.out.println(bytes.length); // 23 elements
                JPerson person1 = mapper.readValue(bytes, JPerson.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        // protobuf
        Person sam = Person.newBuilder()
                .setName("sam")
                .setAge(10)
                .build();
        Runnable protobuf = () -> {
            try {
                byte[] bytes = sam.toByteArray();
                // System.out.println(bytes.length); // 7 elements
                Person sam1 = Person.parseFrom(bytes);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 5; i++) {
            runPerformanceTest(json, "json");
            runPerformanceTest(protobuf, "proto");
        }

        /*
            json 2357ms
            proto 331ms

            json 1961ms
            proto 271ms

            json 1950ms
            proto 269ms

            json 1953ms
            proto 266ms

            json 1960ms
            proto 268ms
        */
    }

    private static void runPerformanceTest(Runnable runnable, String method) {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            runnable.run();
        }
        long time2 = System.currentTimeMillis();

        System.out.println(method + " " + (time2 - time1) + "ms");
    }
}
