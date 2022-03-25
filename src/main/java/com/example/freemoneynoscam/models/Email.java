package com.example.freemoneynoscam.models;

public class Email {

    private int userId;
    private String address;

    public Email(int userId, String address) {
        this.userId = userId;
        this.address = address;
    }


    public int getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }
}
