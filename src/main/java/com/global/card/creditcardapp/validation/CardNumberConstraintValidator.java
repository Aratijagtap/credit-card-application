package com.global.card.creditcardapp.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.stream.IntStream;

public class CardNumberConstraintValidator implements ConstraintValidator<Luhn10, String> {

    private static final Logger log = LoggerFactory.getLogger(CardNumberConstraintValidator.class);

    public boolean isValid(String cardNumber, ConstraintValidatorContext cvc) {

        log.debug("Checking Luhn-10 algorithm ");

        int[] cardIntArray = new int[cardNumber.length()];

        IntStream.range(0, cardNumber.length()).forEach(i -> {
            char c = cardNumber.charAt(i);
            cardIntArray[i] = Integer.parseInt("" + c);
        });

        for (int i = cardIntArray.length - 2; i >= 0; i = i - 2) {
            int num = cardIntArray[i];
            num = num * 2;
            if (num > 9) {
                num = num % 10 + num / 10;
            }
            cardIntArray[i] = num;
        }

        int sum = Arrays.stream(cardIntArray).sum();


        return sum % 10 == 0;
    }
}
