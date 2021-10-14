package com.panaskin.mongodbapp.repository;

import com.panaskin.mongodbapp.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    @Query("{'accounts.accountName'} : ?0 }")
    Customer findCustomerByAccountName(String accountName);

    @Query("{'accounts.cardNumber' : ?0 }")
    Customer findCustomerByCardNumber(String cardNumber);

    @Query("{" +
            "'accounts.expirationDate' : { $lte : new Date() }" +
            "}")
    List<Customer> findCustomersByExpiredCard();

    @Query("{'firstName' : ?0, 'lastName' :?1}")
    List<Customer> findCustomersByFirstAndLastName(String firstName, String lastName);

    List<Customer> findCustomersByFirstName(String firstName);
    List<Customer> findCustomersByLastName(String lastName);
}
