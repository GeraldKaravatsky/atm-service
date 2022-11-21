package com.senla.courses.atm.service.dao;

import com.senla.courses.atm.service.database.DataBase;
import com.senla.courses.atm.service.exception.EntityNotFoundException;
import com.senla.courses.atm.service.model.Account;

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

}
