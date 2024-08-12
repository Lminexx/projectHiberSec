package org.example.DAO;

import org.example.Entity.Inventory;
import org.hibernate.SessionFactory;

public class InventoryDAO extends DaoGeneric<Inventory> {
    public InventoryDAO(SessionFactory sessionFactory) {
        super(Inventory.class, sessionFactory);
    }
}
