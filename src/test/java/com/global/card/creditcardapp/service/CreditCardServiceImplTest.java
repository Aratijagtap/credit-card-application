package com.global.card.creditcardapp.service;

import com.global.card.creditcardapp.dao.CreditCardRepository;
import com.global.card.creditcardapp.exception.CardAlreadyExistsException;
import com.global.card.creditcardapp.model.CardDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardServiceImplTest {

    @Mock
    CreditCardRepository dao;

    @InjectMocks
    private CreditCardServiceImpl service;

    public CardDetails getCardDetailsRequest(){

        CardDetails request=new CardDetails();
        request.setCreditCardNumber("1358954993914435");
        request.setName("John");
        request.setCardLimit(1000.9);
        return request;

    }

    @Test
    public void getAllCardsCall(){

        List<CardDetails> cardList=new ArrayList<>();

        CardDetails card1=new CardDetails();
        card1.setCreditCardNumber("1358954993914435");
        card1.setName("John");
        card1.setCardLimit(300.3);


        CardDetails card2=new CardDetails();
        card2.setCreditCardNumber("49927398716");
        card2.setName("Monica");
        card2.setCardLimit(2000.5);

        cardList.add(card1);
        cardList.add(card2);

        when(dao.findAll()).thenReturn(cardList);
        List result=service.getAllCreditCards();
        verify(dao).findAll();

    }

    @Test
    public void addNewCreditCardCall() throws CardAlreadyExistsException {
        service.addNewCreditCard(getCardDetailsRequest());
        verify(dao, times(1)).save(any());

    }

}
