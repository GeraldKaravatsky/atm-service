package com.senla.courses.atm.service.controller;

import com.senla.courses.atm.service.service.AtmService;
import com.senla.courses.atm.service.service.AtmServiceImpl;
import com.senla.courses.atm.service.util.exception.MenuException;
import com.senla.courses.atm.service.util.menu.MenuUtil;
import com.senla.courses.atm.service.view.Builder;
import com.senla.courses.atm.service.view.Menu;
import com.senla.courses.atm.service.view.MenuItem;
import com.senla.courses.atm.service.view.Navigator;
import com.senla.courses.atm.service.view.actions.CheckBalanceAction;
import com.senla.courses.atm.service.view.actions.ExitAction;
import com.senla.courses.atm.service.view.actions.ReplenishBalanceAction;
import com.senla.courses.atm.service.view.actions.WithdrawMoneyAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        init();

        do {
            this.navigator.printMenu();


            int numberOfItems = this.navigator.getCurrentMenu().getMenuItems().size();
            int menuId = MenuUtil.readItemIdFromConsole(numberOfItems);

            this.navigator.navigate(menuId);
        } while (true);
    }

    private void init() {
        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("Check card balance", new CheckBalanceAction()));
        menuItems.add(new MenuItem("Withdraw money from account", new WithdrawMoneyAction()));
        menuItems.add(new MenuItem("Replenish the balance", new ReplenishBalanceAction()));
        menuItems.add(new MenuItem("Exit", new ExitAction()));

        this.builder.buildMenu("ATM service", menuItems);
        this.navigator.setCurrentMenu(this.builder.getRootMenu());
    }

}
