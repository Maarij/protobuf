package com.example.protobuf;

import com.example.models.Television;
import com.example.models.Type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VersionCompatabilityDemo {

    public static void main(String[] args) throws IOException {
//        Path pathV1 = Paths.get("tv-v1");
        Path pathV2 = Paths.get("tv-v2");

//        Television television = Television.newBuilder()
//                .setBrand("sony")
//                .setYear(2015)
//                .setModel(2016)
//                .setType(Type.OLED)
//                .build();

//        Files.write(pathV2, television.toByteArray());

        // deserialize
        byte[] bytes = Files.readAllBytes(pathV2);
        System.out.println(Television.parseFrom(bytes));
//        System.out.println(Television.parseFrom(bytes).getType());

    }
}
