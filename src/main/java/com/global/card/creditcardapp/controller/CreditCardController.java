package com.global.card.creditcardapp.controller;


import com.global.card.creditcardapp.exception.CardAlreadyExistsException;
import com.global.card.creditcardapp.model.CardDetails;
import com.global.card.creditcardapp.service.CreditCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * This class defines Rest APIs.
 */

@RestController
@RequestMapping("/api/v1/credit-card")
public class CreditCardController {

    private static final Logger log = LoggerFactory.getLogger(CreditCardController.class);

    @Autowired
    CreditCardService creditCardService;

    @GetMapping("/cards")
    public ResponseEntity<List<CardDetails>> getAllCreditCards() {
        log.debug("CreditCardController:getAllCreditCards method started ");
        return new ResponseEntity<>(creditCardService.getAllCreditCards(), HttpStatus.OK);

    }


    @PostMapping("/new-card")
    public ResponseEntity addNewCreditCard(@Valid @RequestBody CardDetails cardDetails) throws CardAlreadyExistsException {
        log.debug("CreditCardController:addNewCreditCard method started");
        try {
            creditCardService.addNewCreditCard(cardDetails);
            log.debug("CreditCardController:addNewCreditCard method finished successfully");
            return new ResponseEntity("Credit card with no:" + cardDetails.getCreditCardNumber() + " added successfully", HttpStatus.CREATED);
        } catch (CardAlreadyExistsException e) {
            log.debug("CreditCardController:addNewCreditCard method finished with CardAlreadyExistsException {}", e);

            return new ResponseEntity(e, HttpStatus.CONFLICT);
        }

    }
}
