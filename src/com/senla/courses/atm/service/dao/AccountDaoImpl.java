package com.senla.courses.atm.service.dao;

import com.senla.courses.atm.service.database.DataBase;
import com.senla.courses.atm.service.exception.EntityNotFoundException;
import com.senla.courses.atm.service.model.Account;

import java.util.List;
import java.util.stream.Collectors;

public class AccountDaoImpl implements AccountDao {

    private final DataBase dataBase;

    private static AccountDao instance;

    private AccountDaoImpl() {
        dataBase = DataBase.getInstance();
    }

    public static AccountDao getInstance() {
        if (instance == null) {
            instance = new AccountDaoImpl();
        }

        return instance;
    }

    @Override
    public Account getByAccountId(Long accountId) {
        return dataBase.getAccounts()
                .stream()
                .filter(account -> accountId.equals(account.getAccountId()))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Account not found by account id %s", accountId));
    }

    @Override
    public void update(Account updatedAccount) {
        // exclude old account
        final List<Account> accounts = dataBase.getAccounts()
                .stream()
                .filter(card -> !updatedAccount.getAccountId().equals(card.getAccountId()))
                .collect(Collectors.toList());

        accounts.add(updatedAccount);

        dataBase.setAccounts(accounts);
    }

}
