package com.panaskin.mongodbapp.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Address {
    private String line1;
    private String line2;
    private Integer countryCode;
}
