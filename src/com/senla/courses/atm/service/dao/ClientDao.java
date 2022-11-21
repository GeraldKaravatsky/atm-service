package com.senla.courses.atm.service.dao;

import com.senla.courses.atm.service.model.Client;

public interface ClientDao {

    Client getByClientId(Long clientId);

}
