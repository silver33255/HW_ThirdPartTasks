package com.panaskin.jointableinhapp.service;


import com.panaskin.jointableinhapp.entity.BillingDetails;
import com.panaskin.jointableinhapp.entity.Buyer;

import java.util.List;

public interface BuyerService {
    List<Buyer> findAllBuyers();
    Buyer saveBuyer(Buyer buyer);
    List<BillingDetails> buyerBilligDetails(Long buyerId);
}
