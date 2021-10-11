package com.panaskin.singletableinhapp.service;

import com.panaskin.singletableinhapp.entity.BankAccount;
import com.panaskin.singletableinhapp.entity.BillingDetails;
import com.panaskin.singletableinhapp.entity.Buyer;
import com.panaskin.singletableinhapp.entity.CreditCard;
import com.panaskin.singletableinhapp.repository.BuyerRepository;
import config.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyerServiceTestIT extends AbstractIntegrationTest {
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private BuyerRepository buyerRepository;

    @Test
    public void saveBuyer_shouldReceiveBuyerWithGivenName(){
        //GIVEN
        Buyer inputBuyer = Buyer.builder().firstName("Gennadiy").build();
        //WHEN
        Long savedBuyerId = buyerService.saveBuyer(inputBuyer).getId();
        Buyer resultBuyer = buyerRepository.getById(savedBuyerId);
        //THEN
        assertEquals("Gennadiy", resultBuyer.getFirstName());
    }

    @Test
    public void findAllBuyers_shouldReceiveListSizeTwo() throws Exception {
        //GIVEN
        Buyer firstBuyer = Buyer.builder().firstName("Vasiluy").build();
        Buyer secondBuyer = Buyer.builder().firstName("Gennadiy").build();
        buyerService.saveBuyer(firstBuyer);
        buyerService.saveBuyer(secondBuyer);
        //WHEN
        List<Buyer> buyers = buyerService.findAllBuyers();
        //THEN
        assertEquals(2, buyers.size());
    }

    @Test
    public void buyerBillingDetails_shouldReceiveListWithTwoBillingDetails() throws Exception {
        Buyer buyer = Buyer.builder().Id(1L).firstName("Gennadiy").build();
        List<BillingDetails> billingDetails = new ArrayList<>();
        billingDetails.add(BankAccount.builder()
                .bankName("Privat")
                .buyer(buyer)
                .build());
        billingDetails.add(CreditCard.builder()
                .cardNumber("12345")
                .buyer(buyer)
                .build());
        buyer.setBillingDetails(billingDetails);
        Long savedBuyerId = buyerRepository.save(buyer).getId();
        //WHEN
        List<BillingDetails> details = buyerService.buyerBilligDetails(savedBuyerId);
        //THEN
        assertEquals(2, details.size());
    }
}
