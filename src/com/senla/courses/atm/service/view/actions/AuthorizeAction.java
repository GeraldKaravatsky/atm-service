package com.senla.courses.atm.service.view.actions;

import com.senla.courses.atm.service.service.AtmService;
import com.senla.courses.atm.service.service.AtmServiceImpl;

import java.util.Scanner;

public class AuthorizeAction implements Action {

    private static final Scanner SCANNER = new Scanner(System.in);

    private final AtmService atmService;

    public AuthorizeAction() {
        atmService = AtmServiceImpl.getInstance();
    }

    @Override
    public void execute() {
        System.out.print("Enter card number: ");
        String cardNumber = SCANNER.nextLine();
        System.out.print("Enter card pin-code: ");
        String pinCode = SCANNER.nextLine();

        atmService.authorize(cardNumber, pinCode);

        System.out.println("You are successfully authorized!");
    }

}
