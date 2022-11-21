package com.senla.courses.atm.service.database;

import com.senla.courses.atm.service.model.Account;
import com.senla.courses.atm.service.model.Card;
import com.senla.courses.atm.service.model.Client;
import com.senla.courses.atm.service.util.database.DataBaseUtil;
import com.senla.courses.atm.service.util.txt.manager.TxtFileReader;
import com.senla.courses.atm.service.util.txt.manager.TxtFileWriter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static DataBase instance;

    private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/com/senla/courses/atm/service/resources/";

    private static final String ACCOUNTS_PATH = RESOURCES_PATH + "accounts.txt";

    private static final String CARDS_PATH = RESOURCES_PATH + "cards.txt";

    private static final String CLIENTS_PATH = RESOURCES_PATH + "clients.txt";

    private static final String ATM_LIMIT_PATH = RESOURCES_PATH + "atm-limit.txt";

    private DataBase() {

    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }

        return instance;
    }

    public List<Account> getAccounts() {
        return DataBaseMapper.getAccountsFromData(TxtFileReader.readDataFromFile(ACCOUNTS_PATH));
    }

    public void setAccounts(List<Account> accounts) {

        TxtFileWriter.writeDataToFile(ACCOUNTS_PATH, DataBaseUtil.getDataFromList(accounts));
    }

    public List<Card> getCards() {
        return DataBaseMapper.getCardsFromData(TxtFileReader.readDataFromFile(CARDS_PATH));
    }

    public void setCards(List<Card> cards) {
        TxtFileWriter.writeDataToFile(CARDS_PATH, DataBaseUtil.getDataFromList(cards));
    }

    public List<Client> getClients() {
        return DataBaseMapper.getClientsFromData(TxtFileReader.readDataFromFile(CLIENTS_PATH));
    }

    public void setClients(List<Client> clients) {
        TxtFileWriter.writeDataToFile(CLIENTS_PATH, DataBaseUtil.getDataFromList(clients));
    }

    public BigDecimal getAtmLimit() {
        return new BigDecimal(TxtFileReader.readSimpleDataFromFile(ATM_LIMIT_PATH));
    }

}
