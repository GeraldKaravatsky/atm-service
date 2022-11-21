package com.senla.courses.atm.service.controller;

import com.senla.courses.atm.service.util.menu.MenuUtil;
import com.senla.courses.atm.service.view.Builder;
import com.senla.courses.atm.service.view.MenuItem;
import com.senla.courses.atm.service.view.Navigator;
import com.senla.courses.atm.service.view.actions.*;

import java.util.ArrayList;
import java.util.List;

public class MenuController {

    private static MenuController instance;

    private final Builder builder;

    private final Navigator navigator;

    private final ClientSession clientSession;

    private MenuController() {
        builder = new Builder();
        navigator = new Navigator();
        clientSession = ClientSession.getInstance();
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
            writeToConsoleHelloMessage();

            navigator.printMainMenu();
            int menuId = MenuUtil.readItemIdFromConsole(navigator.getMenuSize());
            navigator.navigateMainMenu(menuId);

            navigator.printMenu();
            int itemId = MenuUtil.readItemIdFromConsole(navigator.getCurrentMenu().getMenuItemsSize());
            navigator.navigateMenu(itemId);
        } while (true);
    }

    private void init() {
        List<MenuItem> menuItems;

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Authorize client", new AuthorizeAction()));
        this.builder.buildMenu("Authorization", menuItems);
        this.navigator.addMenu(this.builder.getRootMenu());

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Check card balance", new CheckBalanceAction()));
        menuItems.add(new MenuItem("Withdraw money from account", new WithdrawMoneyAction()));
        menuItems.add(new MenuItem("Replenish the balance", new ReplenishBalanceAction()));
        this.builder.buildMenu("ATM service", menuItems);
        this.navigator.addMenu(this.builder.getRootMenu());

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Really exit", new ExitAction()));
        this.builder.buildMenu("Exit", menuItems);
        this.navigator.addMenu(this.builder.getRootMenu());
    }

    private void writeToConsoleHelloMessage() {
        if (clientSession.isAuthorized()) {
            System.out.printf("\nHello our dear customer! Your name: %s%n",
                    clientSession.getClient().getClientFullInfo());
            return;
        }

        System.out.println("\nHello guest!");
    }

}
