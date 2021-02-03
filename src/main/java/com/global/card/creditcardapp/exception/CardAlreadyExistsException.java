package com.global.card.creditcardapp.exception;

/**
 * This class is  to define custom exception: CardAlreadyExistsException.
 */
public class CardAlreadyExistsException extends Exception {

    public CardAlreadyExistsException() {
        super();
    }

    public CardAlreadyExistsException(String message) {
        super(message);
    }
}
