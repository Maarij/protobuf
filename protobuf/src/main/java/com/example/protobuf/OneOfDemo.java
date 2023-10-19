package com.example.protobuf;

import com.example.models.Credentials;
import com.example.models.EmailCredentials;
import com.example.models.PhoneOTP;

public class OneOfDemo {

    public static void main(String[] args) {
        EmailCredentials emailCredentials = EmailCredentials.newBuilder()
                .setEmail("nobody@gmail.com")
                .setPassword("admin123")
                .build();

        PhoneOTP phoneOTP = PhoneOTP.newBuilder()
                .setNumber(1231231234)
                .setCode(456)
                .build();

        Credentials credentials = Credentials.newBuilder()
                .setEmailMode(emailCredentials)
                .setPhoneMode(phoneOTP) // One of email mode or phone mode can be accepted, the last one is taken
                .build();

        login(credentials);

    }

    private static void login(Credentials credentials) {
        switch (credentials.getModeCase()) {
            case EMAILMODE -> System.out.println(credentials.getEmailMode());
            case PHONEMODE -> System.out.println(credentials.getPhoneMode());
        }
    }
}
