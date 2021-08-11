package com.camerer.tickets.dao;

import com.camerer.tickets.model.Address;

public interface AddressDAO {

    Address create(Address address);
    Address getAddressById(long id);
}
