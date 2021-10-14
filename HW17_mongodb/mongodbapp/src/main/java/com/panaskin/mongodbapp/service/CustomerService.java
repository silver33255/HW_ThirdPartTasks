package com.panaskin.mongodbapp.service;

import com.panaskin.mongodbapp.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Optional<Customer> updateCustomer(Customer customer);
    Optional<Customer> findById(String id);
    List<Customer> findByFistNameAndLastName(String firstName, String lastName);
    List<Customer> findAll();
    Optional<Customer> findByCardNumber(String cardNumber);
    List<Customer> findCustomersWithExpiredCards();
    void removeCustomerById(String id);
}
