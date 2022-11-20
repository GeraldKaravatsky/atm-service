package com.senla.courses.atm.service.view;

import java.util.ArrayList;
import java.util.List;

public class Builder {

    private Menu rootMenu;

    private static List<Menu> menuList;

    public List<Menu> getMenuList() {
        if (menuList == null) {
            menuList = new ArrayList<>();
        }

        return menuList;
    }

    public Menu getRootMenu() {
        return this.rootMenu;
    }

    public void buildMenu(String name, List<MenuItem> menuItems) {
        this.rootMenu = new Menu(name, menuItems);
        getMenuList().add(this.rootMenu);
    }

}
