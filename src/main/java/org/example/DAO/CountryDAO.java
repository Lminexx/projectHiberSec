package org.example.DAO;

import org.example.Entity.Country;
import org.hibernate.SessionFactory;

public class CountryDAO extends DaoGeneric<Country> {
    public CountryDAO(SessionFactory sessionFactory) {
        super(Country.class, sessionFactory);
    }
}
