package com.senla.courses.atm.service.view;

import com.senla.courses.atm.service.view.actions.Action;

public class MenuItem {

    private static final String COMPLETED_OPERATION_MESSAGE = "OPERATION COMPLETED SUCCESSFUL";

    private String title;

    private Action action;

    public MenuItem(String title, Action action) {
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return this.title;
    }

    public void doAction() {
        action.execute();
        System.out.println(COMPLETED_OPERATION_MESSAGE + "\n");
    }

}
