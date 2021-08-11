package com.camerer.tickets.dao;

import com.camerer.tickets.exception.ContractorNotFoundException;
import com.camerer.tickets.model.Contractor;

import java.util.List;

public interface ContractorDAO {

    Contractor create(Contractor contractor) throws ContractorNotFoundException;
    List<Contractor> listAll();
    Contractor getContractorById(long id) throws ContractorNotFoundException;
}
