package com.senla.courses.atm.service.util.menu;

import com.senla.courses.atm.service.util.exception.MenuException;

import java.util.Scanner;

public class MenuUtil {

    private static final Scanner SCANNER = new Scanner(System.in);

    private MenuUtil() {

    }

    public static int readItemIdFromConsole(int numberOfItems) {
        if (numberOfItems == 0) {
            throw new MenuException();
        }

        int inputId;

        do {
            inputId = SCANNER.nextInt();

            if (inputId < 1 || inputId > numberOfItems) {
                System.out.println("Incorrect id of menu. Please, enter again");
            }

        } while (inputId < 1 || inputId > numberOfItems);

        return inputId - 1;
    }

}
