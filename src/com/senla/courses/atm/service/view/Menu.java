package com.senla.courses.atm.service.view;

import java.util.List;

public class Menu {

    private String name;

    private List<MenuItem> menuItems;

    public Menu(String name, List<MenuItem> menuItems) {
        this.name = name;
        this.menuItems = menuItems;
    }

    public String getName() {
        return name;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public int getMenuItemsSize() {
        return menuItems.size();
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

}
