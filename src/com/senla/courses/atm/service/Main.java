package com.senla.courses.atm.service;

import com.senla.courses.atm.service.controller.MenuController;

public class Main {

    public static void main(String[] args) {
        MenuController.getInstance().run();
    }

}
