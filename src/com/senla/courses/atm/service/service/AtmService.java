package com.senla.courses.atm.service.service;

public interface AtmService {

    String checkBalance();

    void withdrawMoney(String money);

    void replenishBalance(String money);

}
