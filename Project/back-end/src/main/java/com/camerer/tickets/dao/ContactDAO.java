package com.camerer.tickets.dao;

import com.camerer.tickets.model.Contact;

public interface ContactDAO {

    Contact create(Contact contact);
    Contact getContactById(long id);
}
