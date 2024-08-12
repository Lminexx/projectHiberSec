package org.example.DAO;

import org.example.Entity.Store;
import org.hibernate.SessionFactory;

public class StoreDAO extends DaoGeneric<Store> {
    public StoreDAO(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }
}
