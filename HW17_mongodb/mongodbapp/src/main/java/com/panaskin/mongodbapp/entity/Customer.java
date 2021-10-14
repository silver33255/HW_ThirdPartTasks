package com.panaskin.mongodbapp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@Document(collection = "customer")
public class Customer {
    @Id
    private String id = UUID.randomUUID().toString();
    private String firstName;
    private String lastName;
    private Address address;
    private List<Account> accounts;
}
