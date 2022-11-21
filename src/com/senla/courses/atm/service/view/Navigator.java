package com.senla.courses.atm.service.view;

import java.util.ArrayList;
import java.util.List;

public class Navigator {

    private List<Menu> menuList = new ArrayList<>();

    private Menu currentMenu;

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void addMenu(Menu menu) {
        menuList.add(menu);
    }

    public int getMenuSize() {
        return menuList.size();
    }

    public void printMainMenu() {
        StringBuilder menuSb = new StringBuilder();

        for (int i = 0; i< menuList.size(); i++) {
            menuSb.append(i + 1).append(". ").append(menuList.get(i).getName()).append("\n");
        }

        System.out.println(menuSb);
    }

    public void printMenu() {
        StringBuilder menuSb = new StringBuilder();

        menuSb.append("***").append(currentMenu.getName()).append("***\n");

        List<MenuItem> menuItems = currentMenu.getMenuItems();

        for (int i = 0; i< menuItems.size(); i++) {
            menuSb.append(i + 1).append(". ").append(menuItems.get(i).getTitle()).append("\n");
        }

        System.out.println(menuSb);
    }

    public void navigateMainMenu(Integer menuId) {
        currentMenu = menuList.get(menuId);
    }

    public void navigateMenu(Integer itemId) {
        currentMenu.getMenuItems().get(itemId).doAction();
    }

}
