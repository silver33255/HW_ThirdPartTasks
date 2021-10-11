package com.panaskin.singletableinhapp.service.impl;

import com.panaskin.singletableinhapp.entity.BillingDetails;
import com.panaskin.singletableinhapp.entity.Buyer;
import com.panaskin.singletableinhapp.repository.BuyerRepository;
import com.panaskin.singletableinhapp.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerRepository buyerRepository;

    @Override
    public List<Buyer> findAllBuyers() {
        return buyerRepository.findAll();
    }

    @Override
    public Buyer saveBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public List<BillingDetails> buyerBilligDetails(Long buyerId) {
        return buyerRepository.getById(buyerId).getBillingDetails();
    }
}