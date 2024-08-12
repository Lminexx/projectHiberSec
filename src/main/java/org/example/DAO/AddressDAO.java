package org.example.DAO;

import org.example.Entity.Address;
import org.hibernate.SessionFactory;

public class AddressDAO extends DaoGeneric<Address>{
    public AddressDAO(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }
}
