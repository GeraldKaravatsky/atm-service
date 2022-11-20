package com.senla.courses.atm.service.controller;

import com.senla.courses.atm.service.service.AtmService;
import com.senla.courses.atm.service.service.AtmServiceImpl;
import com.senla.courses.atm.service.view.Builder;
import com.senla.courses.atm.service.view.Menu;
import com.senla.courses.atm.service.view.Navigator;

public class MenuController {

    private static MenuController instance;

    private final AtmService atmService;

    private final Builder builder;

    private final Navigator navigator;

    private MenuController() {
        atmService = AtmServiceImpl.getInstance();
        builder = new Builder();
        navigator = new Navigator();
    }

    public static MenuController getInstance() {
        if (instance == null) {
            instance = new MenuController();
        }

        return instance;
    }

    public void run() {

    }

    private void init() {
        Menu nextMenu = null;
    }

}
