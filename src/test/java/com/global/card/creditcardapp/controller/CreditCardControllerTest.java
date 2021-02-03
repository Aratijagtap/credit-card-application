package com.global.card.creditcardapp.controller;

import com.global.card.creditcardapp.model.CardDetails;
import com.global.card.creditcardapp.service.CreditCardServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@WebMvcTest()
@WebAppConfiguration
public class CreditCardControllerTest {

    private static final Logger log = LoggerFactory.getLogger(CreditCardControllerTest.class);
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private CreditCardServiceImpl service;

    @Test
    public void getAllCreditCardsCall() throws Exception {

            Mockito.when(service.getAllCreditCards()).thenReturn(new ArrayList<>() );

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/v1/credit-card/cards").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            log.info("JUnit getAllCreditCards Response :: " + result.getResponse().getContentAsString());
            MockHttpServletResponse response = result.getResponse();

            assertEquals(HttpStatus.OK.value(), response.getStatus());

        log.info(" getAllCreditCards Call from CreditCardControllerTest");

    }
}

