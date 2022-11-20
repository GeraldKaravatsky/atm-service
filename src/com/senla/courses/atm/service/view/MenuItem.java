package com.senla.courses.atm.service.view;

public class MenuItem {

    private static final String COMPLETED_OPERATION_MESSAGE = "OPERATION COMPLETED SUCCESSFUL";

    private String title;

    private Action action;

    private Menu nextMenu;

    public String getTitle() {
        return this.title;
    }

    public void setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;
    }

    public void doAction() {
        action.execute();
        System.out.println(COMPLETED_OPERATION_MESSAGE + "\n");
    }

}
