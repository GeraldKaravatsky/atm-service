package com.senla.courses.atm.service.view;

import java.util.List;

public class Builder {

    private Menu rootMenu;

    public Menu getRootMenu() {
        return this.rootMenu;
    }

    public void buildMenu(String name, List<MenuItem> menuItems) {
        this.rootMenu = new Menu(name, menuItems);
    }

}
