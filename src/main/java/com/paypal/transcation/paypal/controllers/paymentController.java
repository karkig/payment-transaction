package com.paypal.transcation.paypal.controllers;


import com.paypal.transcation.paypal.dto.ApiResponse;
import com.paypal.transcation.paypal.dto.UserRequest;
import com.paypal.transcation.paypal.enums.TransactionsType;
import com.paypal.transcation.paypal.services.PaymentTransactionService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static com.paypal.transcation.paypal.constants.AppConstants.DATE_TIME_PATTERN;


@RestController
public class paymentController {

    @Autowired
    Logger logger;

    @Autowired
    PaymentTransactionService paymentTransactionService;

    @GetMapping(value = "/transactions")
    public ApiResponse paymentTransactions(@RequestParam(value = "userId", required = false) String userId,
                                           @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = DATE_TIME_PATTERN) LocalDateTime dateAndTime,
                                           @RequestParam(value = "transactionType", required = false) TransactionsType transactionType) {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserId(userId);
        userRequest.setDate(dateAndTime);
        userRequest.setTransactionType(transactionType);
        logger.info(userRequest);
        return paymentTransactionService.getPaymentTransactionDetails(userRequest);

    }
}