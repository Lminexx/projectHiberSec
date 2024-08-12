package org.example.DAO;

import org.example.Entity.Payment;
import org.hibernate.SessionFactory;

public class PaymentDAO extends DaoGeneric<Payment>{
    public PaymentDAO(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }
}
