package com.paypal.transcation.paypal.dto;


import com.paypal.transcation.paypal.model.TransactionDetail;

import java.util.List;

public class SearchResponse extends ApiResponse {
   public List<TransactionDetail> transactions;

    public List<TransactionDetail> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDetail> transactions) {
        this.transactions = transactions;
    }

    public SearchResponse()
    {

    }
    public SearchResponse(String msz,boolean status)
    {
        super(msz,status);
    }
}
