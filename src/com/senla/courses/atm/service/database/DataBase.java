package com.senla.courses.atm.service.database;

import com.senla.courses.atm.service.model.Account;
import com.senla.courses.atm.service.model.Card;
import com.senla.courses.atm.service.model.Client;
import com.senla.courses.atm.service.util.database.DataBaseUtil;
import com.senla.courses.atm.service.util.txt.manager.TxtFileReader;
import com.senla.courses.atm.service.util.txt.manager.TxtFileWriter;

import java.math.BigDecimal;
import java.util.List;

public class DataBase {

    private static DataBase instance;

    private static final String ACCOUNTS_PATH = "com/senla/courses/atm/service/resources/accounts.txt";

    private static final String CARDS_PATH = "com/senla/courses/atm/service/resources/cards.txt";

    private static final String CLIENTS_PATH = "com/senla/courses/atm/service/resources/clients.txt";

    private static final String ATM_LIMIT_PATH = "com/senla/courses/atm/service/resources/atm-limit.txt";

    private DataBase() {

    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }

        return instance;
    }

    public List<Account> getAccounts() {
        return DataBaseUtil.getListFromData(Account.class, TxtFileReader.readDataFromFile(ACCOUNTS_PATH));
    }

    public void setAccounts(List<Account> accounts) {
        TxtFileWriter.writeDataToFile(ACCOUNTS_PATH, DataBaseUtil.getDataFromList(accounts));
    }

    public List<Card> getCards() {
        return DataBaseUtil.getListFromData(Card.class, TxtFileReader.readDataFromFile(CARDS_PATH));
    }

    public void setCards(List<Card> cards) {
        TxtFileWriter.writeDataToFile(CARDS_PATH, DataBaseUtil.getDataFromList(cards));
    }

    public List<Client> getClients() {
        return DataBaseUtil.getListFromData(Client.class, TxtFileReader.readDataFromFile(CLIENTS_PATH));
    }

    public void setClients(List<Client> clients) {
        TxtFileWriter.writeDataToFile(CLIENTS_PATH, DataBaseUtil.getDataFromList(clients));
    }

    public BigDecimal getAtmLimit() {
        return new BigDecimal(TxtFileReader.readSimpleDataFromFile(ATM_LIMIT_PATH));
    }

}
