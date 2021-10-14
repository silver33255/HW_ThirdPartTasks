package com.panaskin.mongodbapp.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@Document
public class Account {
    @Indexed
    private String cardNumber;
    private String nameOnAccount;
    private LocalDate expirationDate;
}
