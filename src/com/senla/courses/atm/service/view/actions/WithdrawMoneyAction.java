package com.senla.courses.atm.service.view.actions;

import com.senla.courses.atm.service.service.AtmService;
import com.senla.courses.atm.service.service.AtmServiceImpl;

import java.util.Scanner;

public class WithdrawMoneyAction implements Action {

    private static final Scanner SCANNER = new Scanner(System.in);

    private final AtmService atmService;

    public WithdrawMoneyAction() {
        atmService = AtmServiceImpl.getInstance();
    }

    @Override
    public void execute() {
        System.out.print("Enter amount of money: ");
        String money = SCANNER.nextLine();

        atmService.withdrawMoney(money);
    }

}
