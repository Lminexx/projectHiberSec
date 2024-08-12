package org.example.DAO;

import org.example.Entity.City;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CityDAO extends DaoGeneric<City> {
    public CityDAO(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }

    public City getCity(String name) {
        Query<City> query = getSessionFactory().createQuery("select c from City c where c.city = :name", City.class);
        query.setParameter("name", name);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
