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
@DiscriminatorValue(value = "BA")
@PrimaryKeyJoinColumn(name = "accountId")
public class BankAccount extends BillingDetails {
    private String account;
    private String bankName;
}
