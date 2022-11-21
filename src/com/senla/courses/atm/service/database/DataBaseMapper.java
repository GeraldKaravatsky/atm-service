package com.senla.courses.atm.service.database;

import com.senla.courses.atm.service.model.Account;
import com.senla.courses.atm.service.model.Card;
import com.senla.courses.atm.service.model.CardStatus;
import com.senla.courses.atm.service.model.Client;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DataBaseMapper {

    private DataBaseMapper() {

    }

    public static List<Account> getAccountsFromData(List<List<String>> data) {
        return data
                .stream()
                // skip fields names
                .skip(1)
                .map(DataBaseMapper::getAccount)
                .collect(Collectors.toList());
    }

    public static List<Card> getCardsFromData(List<List<String>> data) {
        return data
                .stream()
                // skip fields names
                .skip(1)
                .map(DataBaseMapper::getCard)
                .collect(Collectors.toList());
    }

    public static List<Client> getClientsFromData(List<List<String>> data) {
        return data
                .stream()
                // skip fields names
                .skip(1)
                .map(DataBaseMapper::getClient)
                .collect(Collectors.toList());
    }

    private static Account getAccount(List<String> fields) {
        return new Account(Long.valueOf(fields.get(0)),
                Long.valueOf(fields.get(1)),
                fields.get(2),
                fields.get(3),
                new BigDecimal(fields.get(4)));
    }

    private static Card getCard(List<String> fields) {
        return new Card(Long.valueOf(fields.get(0)),
                Long.valueOf(fields.get(1)),
                fields.get(2),
                fields.get(3),
                Integer.valueOf(fields.get(4)),
                CardStatus.valueOf(fields.get(5)),
                !fields.get(6).equals("null") ? LocalDateTime.parse(fields.get(6)) : null);
    }

    private static Client getClient(List<String> fields) {
        return new Client(Long.valueOf(fields.get(0)), fields.get(1), fields.get(2), fields.get(3));
    }

}
