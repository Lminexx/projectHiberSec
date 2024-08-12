package org.example.DAO;

import org.example.Entity.Rental;
import org.hibernate.SessionFactory;

public class RentalDAO extends DaoGeneric<Rental> {
    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }
}
