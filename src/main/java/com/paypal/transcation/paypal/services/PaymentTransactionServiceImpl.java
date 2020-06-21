package com.paypal.transcation.paypal.services;

import com.paypal.transcation.paypal.dao.PaymentTransactionDao;
import com.paypal.transcation.paypal.dto.SearchResponse;
import com.paypal.transcation.paypal.dto.UserRequest;
import com.paypal.transcation.paypal.model.TransactionDetail;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentTransactionServiceImpl implements PaymentTransactionService {

    @Autowired
    PaymentTransactionDao paymentTransactionDao;
    @Autowired
    Logger logger;

    @Override
    public SearchResponse getPaymentTransactionDetails(UserRequest userRequest) {
        Optional<List<TransactionDetail>> transactionDetails = paymentTransactionDao.getTransactionDetails(userRequest.getUserId(), userRequest.getTransactionType(), userRequest.getDate());
        return transactionDetails.map(item -> {
            SearchResponse searchResponse = new SearchResponse();
            searchResponse.setTransactions(item);
            logger.info(item);
            searchResponse.setMessage("Data fetch with size :" + item.size());
            searchResponse.setStatus(true);
            return searchResponse;
        }).orElse(new SearchResponse("No data found.",false));


    }
}
