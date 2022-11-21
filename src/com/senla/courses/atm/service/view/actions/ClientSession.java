package com.senla.courses.atm.service.view.actions;

import com.senla.courses.atm.service.model.Card;
import com.senla.courses.atm.service.model.Client;

public class ClientSession {

    private static ClientSession instance;

    private boolean isAuthorized;

    private Client client;

    private Card card;

    private ClientSession() {

    }

    public static ClientSession getInstance() {
        if (instance == null) {
            instance = new ClientSession();
        }

        return instance;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}
