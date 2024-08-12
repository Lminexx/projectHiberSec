package org.example.DAO;

import org.example.Entity.City;
import org.hibernate.SessionFactory;

public class CityDAO extends DaoGeneric<City> {
    public CityDAO(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }
}
