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
        return title;
    }

    public void doAction() {
        try {
            action.execute();
            System.out.println(COMPLETED_OPERATION_MESSAGE + "\n");
        } catch (Exception e) {
            System.out.printf("ERROR. Message: %s. Cause: %s%n", e.getMessage(), e.getCause());
        }
    }

}
