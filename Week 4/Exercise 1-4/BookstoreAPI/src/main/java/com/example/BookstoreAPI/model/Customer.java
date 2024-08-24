package com.example.BookstoreAPI.model;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
}

