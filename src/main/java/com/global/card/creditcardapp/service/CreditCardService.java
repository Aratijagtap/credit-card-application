package com.global.card.creditcardapp.service;

import com.global.card.creditcardapp.exception.CardAlreadyExistsException;
import com.global.card.creditcardapp.model.CardDetails;

import java.util.List;

/**
 * This interface is to define abstraction of CreditCardServiceImpl.
 */

public interface CreditCardService {

   List<CardDetails> getAllCreditCards();
   String addNewCreditCard(CardDetails cardDetails) throws CardAlreadyExistsException;
}
