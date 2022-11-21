package com.senla.courses.atm.service.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Card {

    private Long clientId;

    private Long accountId;

    private String number;

    private String pinCode;

    private Integer attemptsCount;

    private CardStatus status;

    private LocalDateTime blockDate;

    public Card(Long clientId,
                Long accountId,
                String number,
                String pinCode,
                Integer attemptsCount,
                CardStatus status,
                LocalDateTime blockDate) {
        this.clientId = clientId;
        this.accountId = accountId;
        this.number = number;
        this.pinCode = pinCode;
        this.attemptsCount = attemptsCount;
        this.status = status;
        this.blockDate = blockDate;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getNumber() {
        return number;
    }

    public String getPinCode() {
        return pinCode;
    }

    public Integer getAttemptsCount() {
        return attemptsCount;
    }

    public void setAttemptsCount(Integer attemptsCount) {
        this.attemptsCount = attemptsCount;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public LocalDateTime getBlockDate() {
        return blockDate;
    }

    public void setBlockDate(LocalDateTime blockDate) {
        this.blockDate = blockDate;
    }
}
