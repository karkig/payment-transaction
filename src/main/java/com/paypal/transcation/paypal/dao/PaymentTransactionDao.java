package com.paypal.transcation.paypal.dao;


import com.paypal.transcation.paypal.enums.TransactionsType;
import com.paypal.transcation.paypal.model.TransactionDetail;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PaymentTransactionDao {
    Optional<List<TransactionDetail>> getTransactionDetails(String userId, TransactionsType transactionsType, LocalDateTime dateTime);
}
