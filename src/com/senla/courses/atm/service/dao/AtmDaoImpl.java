package com.senla.courses.atm.service.dao;

import com.senla.courses.atm.service.database.DataBase;

import java.math.BigDecimal;

public class AtmDaoImpl implements AtmDao {

    private final DataBase dataBase;

    private static AtmDao instance;

    public AtmDaoImpl() {
        dataBase = DataBase.getInstance();
    }

    public static AtmDao getInstance() {
        if (instance == null) {
            instance = new AtmDaoImpl();
        }

        return instance;
    }

    @Override
    public BigDecimal getLimit() {
        return dataBase.getAtmLimit();
    }

}
