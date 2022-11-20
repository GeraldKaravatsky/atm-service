package com.senla.courses.atm.service.service;

public class AtmServiceImpl implements AtmService {

    private static AtmService instance;

    private AtmServiceImpl() {

    }

    public static AtmService getInstance() {
        if (instance == null) {
            instance = new AtmServiceImpl();
        }

        return instance;
    }

    @Override
    public void checkBalance() {

    }
}
