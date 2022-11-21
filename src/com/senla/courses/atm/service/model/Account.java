package com.senla.courses.atm.service.model;

import java.math.BigDecimal;

public class Account {

    private Long accountId;

    private Long clientId;

    private String number;

    private String currency;

    private BigDecimal amount;

    public Account(Long accountId, Long clientId, String number, String currency, BigDecimal amount) {
        this.accountId = accountId;
        this.clientId = clientId;
        this.number = number;
        this.currency = currency;
        this.amount = amount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getBalance() {
        return amount + " " + currency;
    }

}
