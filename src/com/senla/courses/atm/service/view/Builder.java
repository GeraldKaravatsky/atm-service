package com.senla.courses.atm.service.view;

import java.util.List;

public class Builder {

    private Menu rootMenu;

    public Menu getRootMenu() {
        return rootMenu;
    }

    public void buildMenu(String name, List<MenuItem> menuItems) {
        rootMenu = new Menu(name, menuItems);
    }

}
