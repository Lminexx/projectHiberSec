package org.example.DAO;

import org.example.Entity.Staff;
import org.hibernate.SessionFactory;

public class StaffDAO extends DaoGeneric<Staff> {
    public StaffDAO(SessionFactory sessionFactory) {
        super(Staff.class, sessionFactory);
    }
}
