package com.senla.courses.atm.service.service;

public interface AuthorizationService {

    void authorize(String cardNumber, String pinCode);

}
