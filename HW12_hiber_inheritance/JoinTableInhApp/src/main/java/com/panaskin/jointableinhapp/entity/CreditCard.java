package com.panaskin.jointableinhapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue(value = "CC")
@PrimaryKeyJoinColumn(name ="cardId")
public class CreditCard extends BillingDetails{
    private String cardNumber;
    private int expYear;
    private int expMonth;
}
