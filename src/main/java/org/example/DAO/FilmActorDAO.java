package org.example.DAO;

import org.example.Entity.FilmActor;
import org.hibernate.SessionFactory;

public class FilmActorDAO extends DaoGeneric<FilmActor> {
    public FilmActorDAO(SessionFactory sessionFactory) {
        super(FilmActor.class, sessionFactory);
    }
}
