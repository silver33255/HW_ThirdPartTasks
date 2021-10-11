package com.panaskin.singletableinhapp.service;


import com.panaskin.singletableinhapp.entity.BillingDetails;
import com.panaskin.singletableinhapp.entity.Buyer;

import java.util.List;

public interface BuyerService {
    List<Buyer> findAllBuyers();
    Buyer saveBuyer(Buyer buyer);
    List<BillingDetails> buyerBilligDetails(Long buyerId);
}
