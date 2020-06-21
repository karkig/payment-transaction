package com.paypal.transcation.paypal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.paypal.transcation.paypal.constants.AppConstants;
import com.paypal.transcation.paypal.enums.TransactionsType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class TransactionDetail  {
    @Id
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TransactionsType type;


    @Column(name = "transaction_date")
    @JsonFormat(pattern = AppConstants.DATE_TIME_PATTERN)
    private LocalDateTime transactionDate;


 /*   private BigDecimal purchasePrice;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =  "MM/dd/yyyy")
    private Date purchaseDate;*/
    public TransactionDetail(){
    }

    @Override
    public String toString() {
        return "TransactionDetail{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TransactionsType getType() {
        return type;
    }

    public void setType(TransactionsType type) {
        this.type = type;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}