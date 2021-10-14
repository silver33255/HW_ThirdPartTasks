package com.panaskin.mongodbapp.service;

import com.panaskin.mongodbapp.entity.Account;
import com.panaskin.mongodbapp.entity.Customer;
import com.panaskin.mongodbapp.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerServiceIT {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    void cleanRepo() {
        customerRepository.deleteAll();
    }

    @Test
    void shouldReceiveCustomerWithIdWhenFindById() {
        //GIVEN
        Customer customer = Customer.builder().id(UUID.randomUUID().toString()).build();
        String expectedId = customer.getId();
        customerService.saveCustomer(customer);
        //WHEN
        String resultId = customerService.findById(customer.getId()).get().getId();
        //THEN
        assertEquals(expectedId, resultId);
    }

    @Test
    void shouldReceiveCustomerWithTheSameNameWhenSaveCustomer() {
        //GIVEN
        Customer customer = Customer.builder().firstName("FirstName").build();
        //WHEN
        String customerId = customerService.saveCustomer(customer).getId();
        //THEN
        Customer expectedCustomer = customerService.findById(customerId).get();
        assertEquals("FirstName", expectedCustomer.getFirstName());
    }

    @Test
    void shouldReceiveUpdatedCustomerLastNameWhenUpdateCustomer() {
        //GIVEN
        Customer customer = Customer.builder().lastName("BaseLastName").build();
        customerService.saveCustomer(customer);
        customer.setLastName("UpdatedLastName");
        //WHEN
        Optional<Customer> expectedCustomer = customerService.updateCustomer(customer);
        //THEN
        assertNotNull(expectedCustomer.get());
        assertEquals("UpdatedLastName", expectedCustomer.get().getLastName());
    }

    @Test
    void shouldReceiveTwoCustomersWhenfindByFistNameAndLastName() {
        //GIVEN
        int expectedCustumerQuantity = 2;
        String firstName = "testFirstName";
        String lastName = "TestLastName";
        customerService.saveCustomer(Customer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build());
        customerService.saveCustomer(Customer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build());
        customerService.saveCustomer(Customer.builder()
                .firstName("anotherFirstName")
                .lastName("anotherLastName")
                .build());
        //WHEN
        int resultCustomerQuantity = customerService.findByFistNameAndLastName(firstName, lastName).size();
        //THEN
        assertEquals(expectedCustumerQuantity, resultCustomerQuantity);
    }

    @Test
    void shouldReceiveThreeCustomersWhenFindAll() {
        //GIVEN
        int expectedQuentity = 3;
        customerService.saveCustomer(Customer.builder().build());
        customerService.saveCustomer(Customer.builder().build());
        customerService.saveCustomer(Customer.builder().build());
        //WHEN
        int resultQuentity = customerService.findAll().size();
        //THEN
        assertEquals(expectedQuentity, resultQuentity);
    }

    @Test
    void shouldReceiveCustomerWithExpectedFirstNameWhenfindByCardNumber() {
        //GIVEN
        String number = "12345";
        String expectedCustomerName = "Dendy";
        Account account = Account.builder().cardNumber(number).build();
        customerService.saveCustomer(Customer.builder().firstName(expectedCustomerName).accounts(Arrays.asList(account)).build());
        //WHEN
        Optional<Customer> customer = customerService.findByCardNumber(number);
        //THEN
        assertEquals(expectedCustomerName, customer.get().getFirstName());
    }

    @Test
    void shouldReceiveTwoCustomersWithCardsAreExpiredWhenfindCustomersWithExpiredCards() {
        //GIVEN
        LocalDate expiredDate = LocalDate.of(2021, 1, 5);
        LocalDate notExpiredDate = LocalDate.of(2021, 11, 12);
        customerRepository.save(Customer.builder()
                .accounts(Arrays.asList(Account.builder()
                        .expirationDate(expiredDate)
                        .build())).build());
        customerRepository.save(Customer.builder()
                .accounts(Arrays.asList(Account.builder()
                        .expirationDate(expiredDate)
                        .build())).build());
        customerRepository.save(Customer.builder()
                .accounts(Arrays.asList(Account.builder()
                        .expirationDate(notExpiredDate)
                        .build())).build());
        //WHEN
        List<Customer> customers = customerService.findCustomersWithExpiredCards();
        //THEN
        assertEquals(2, customers.size());
    }

    @Test
    void shouldReceiveListWithOneCustomerWhenRemoveCustomerById(){
        //GIVEN
        int expectedCustomerQuantity = 1;
        String customerId = UUID.randomUUID().toString();
        customerService.saveCustomer(Customer.builder().id(customerId).build());
        customerService.saveCustomer(Customer.builder().id(UUID.randomUUID().toString()).build());
        //WHEN
        customerService.removeCustomerById(customerId);
        //THEN
        assertEquals(expectedCustomerQuantity, customerService.findAll().size());
    }
}
