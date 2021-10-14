package com.panaskin.mongodbapp.service.impl;

import com.panaskin.mongodbapp.entity.Customer;
import com.panaskin.mongodbapp.repository.CustomerRepository;
import com.panaskin.mongodbapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> updateCustomer(Customer customer) {
        Optional<Customer> customerToUpdate = customerRepository.findById(customer.getId());
        if (customerToUpdate.isPresent()) {
           return Optional.of(customerRepository.save(customer));
        }
        return customerToUpdate;
    }

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> findByCardNumber(String cardNumber) {
        return Optional.of(customerRepository.findCustomerByCardNumber(cardNumber));
    }

    @Override
    public List<Customer> findCustomersWithExpiredCards() {
        return customerRepository.findCustomersByExpiredCard();
    }

    @Override
    public void removeCustomerById(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findByFistNameAndLastName(String firstName, String lastName) {
        return customerRepository.findCustomersByFirstAndLastName(firstName, lastName);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
