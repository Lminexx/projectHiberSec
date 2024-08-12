package org.example.DAO;

import org.example.Entity.Customer;
import org.hibernate.SessionFactory;

public class CustomerDAO extends DaoGeneric<Customer> {
    public CustomerDAO(SessionFactory sessionFactory) {
        super(Customer.class, sessionFactory);
    }
}
