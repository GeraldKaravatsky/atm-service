package com.senla.courses.atm.service.view.actions;

import com.senla.courses.atm.service.service.AtmService;
import com.senla.courses.atm.service.service.AtmServiceImpl;

public class CheckBalanceAction implements Action {

    private final AtmService atmService;

    public CheckBalanceAction() {
        atmService = AtmServiceImpl.getInstance();
    }

    @Override
    public void execute() {
        String balance = atmService.checkBalance();

        System.out.printf("Current account balance: %s%n", balance);
    }

}
