package com.senla.courses.atm.service.service;

public interface AtmService {

    void authorize(String cardNumber, String pinCode);

    String checkBalance();

}
