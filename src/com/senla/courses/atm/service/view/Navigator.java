package com.senla.courses.atm.service.view;

import java.util.List;

public class Navigator {

    private Menu currentMenu;

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public Menu getCurrentMenu() {
        return this.currentMenu;
    }

    public void printMenu() {
        StringBuilder menuSb = new StringBuilder();

        menuSb.append("***").append(this.currentMenu.getName()).append("***\n");

        List<MenuItem> menuItems = currentMenu.getMenuItems();

        for (int i = 0; i< menuItems.size(); i++) {
            menuSb.append(i).append(". ").append(menuItems.get(i).getTitle()).append("\n");
        }

        System.out.println(menuSb);
    }

    public void navigate(Integer index) {
        currentMenu.getMenuItems().get(index).doAction();
    }

}
