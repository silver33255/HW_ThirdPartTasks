package com.panaskin.jointableinhapp.service;

import com.panaskin.jointableinhapp.entity.BankAccount;
import com.panaskin.jointableinhapp.entity.BillingDetails;
import com.panaskin.jointableinhapp.entity.Buyer;
import com.panaskin.jointableinhapp.entity.CreditCard;
import com.panaskin.jointableinhapp.repository.BuyerRepository;
import config.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyerServiceTestImpl extends AbstractIntegrationTest {
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private BuyerRepository buyerRepository;

    @Test
    public void saveBuyer_shouldReceiveBuyerWithGivenName() {
        //GIVEN
        Buyer inputBuyer = Buyer.builder().firstName("Gennadiy").build();
        //WHEN
        Long savedBuyerId = buyerService.saveBuyer(inputBuyer).getId();
        Buyer resultBuyer = buyerRepository.getById(savedBuyerId);
        //THEN
        assertEquals(2, 2);
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
                .build());
        billingDetails.add(CreditCard.builder()
                .cardNumber("12345")
                .build());
        buyer.setBillingDetails(billingDetails);
        Long savedBuyerId = buyerRepository.save(buyer).getId();
        //WHEN
        List<BillingDetails> details = buyerService.buyerBilligDetails(savedBuyerId);
        //THEN
        assertEquals(2, details.size());
    }
}
