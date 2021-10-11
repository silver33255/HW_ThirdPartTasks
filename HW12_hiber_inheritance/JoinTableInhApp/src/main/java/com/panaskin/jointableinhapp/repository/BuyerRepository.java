package com.panaskin.jointableinhapp.repository;

import com.panaskin.jointableinhapp.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
