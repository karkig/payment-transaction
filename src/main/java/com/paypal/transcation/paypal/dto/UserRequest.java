package com.paypal.transcation.paypal.dto;

import com.paypal.transcation.paypal.enums.TransactionsType;

import java.time.LocalDateTime;

public class UserRequest {
    private String userId;
    private LocalDateTime date;
    private TransactionsType transactionType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public TransactionsType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionsType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "UserRequest" +
                "{" +
                "userId='" + userId + '\'' +
                ", date=" + date +
                ", transactionType=" + transactionType +
                '}';
    }
}
