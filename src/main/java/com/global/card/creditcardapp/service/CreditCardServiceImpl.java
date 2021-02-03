package com.global.card.creditcardapp.service;

import com.global.card.creditcardapp.dao.CreditCardRepository;
import com.global.card.creditcardapp.exception.CardAlreadyExistsException;
import com.global.card.creditcardapp.model.CardDetails;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is implementing CreditCardService interface .
 */
@Service
public class CreditCardServiceImpl implements CreditCardService {

    private static final Logger log = LoggerFactory.getLogger(CreditCardServiceImpl.class);

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Override
    public List<CardDetails> getAllCreditCards() {
        log.debug("List of credit cards");
        return creditCardRepository.findAll();
    }





    @Override
    public String addNewCreditCard(CardDetails cardDetails) throws CardAlreadyExistsException {
        try {
            creditCardRepository.save(cardDetails);
            log.debug("New credit card added successfully");
            return "Successfully";
        } catch (ConstraintViolationException | DuplicateKeyException e) {
            log.error("Card already exist");
            throw new CardAlreadyExistsException("Card already exists.");
        }


    }
}
