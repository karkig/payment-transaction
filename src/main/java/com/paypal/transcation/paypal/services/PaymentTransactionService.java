package com.paypal.transcation.paypal.services;

import com.paypal.transcation.paypal.dto.SearchResponse;
import com.paypal.transcation.paypal.dto.UserRequest;
import org.springframework.stereotype.Service;

@Service
public interface PaymentTransactionService {

    SearchResponse getPaymentTransactionDetails(UserRequest userRequest);

}
