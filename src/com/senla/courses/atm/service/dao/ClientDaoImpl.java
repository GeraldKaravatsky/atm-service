package com.senla.courses.atm.service.dao;

import com.senla.courses.atm.service.database.DataBase;
import com.senla.courses.atm.service.exception.EntityNotFoundException;
import com.senla.courses.atm.service.model.Client;

public class ClientDaoImpl implements ClientDao {

    private final DataBase dataBase;

    private static ClientDao instance;

    private ClientDaoImpl() {
        dataBase = DataBase.getInstance();
    }

    public static ClientDao getInstance() {
        if (instance == null) {
            instance = new ClientDaoImpl();
        }

        return instance;
    }

    @Override
    public Client getByClientId(Long clientId) {
        return dataBase.getClients()
                .stream()
                .filter(client -> clientId.equals(client.getId()))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Client not found by client id %s", clientId));
    }

}
