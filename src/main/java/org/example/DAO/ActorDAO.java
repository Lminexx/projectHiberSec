package org.example.DAO;

import org.example.Entity.Actor;
import org.hibernate.SessionFactory;

public class ActorDAO extends DaoGeneric<Actor> {

    public ActorDAO(SessionFactory sessionFactory) {
        super(Actor.class, sessionFactory);
    }
}
