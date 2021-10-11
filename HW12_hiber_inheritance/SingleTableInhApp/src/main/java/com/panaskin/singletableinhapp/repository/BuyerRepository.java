package com.panaskin.singletableinhapp.repository;

import com.panaskin.singletableinhapp.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
