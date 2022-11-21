package com.senla.courses.atm.service.dao;

import com.senla.courses.atm.service.model.Account;

public interface AccountDao {

    Account getByAccountId(Long accountId);

    void update(Account updatedAccount);

}
