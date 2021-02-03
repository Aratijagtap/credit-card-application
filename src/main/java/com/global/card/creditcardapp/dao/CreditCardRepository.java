package com.global.card.creditcardapp.dao;

import com.global.card.creditcardapp.model.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class is  to define repository.
 */
@Repository
public interface CreditCardRepository extends JpaRepository<CardDetails, String> {
}
