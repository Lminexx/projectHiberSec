package org.example.DAO;

import org.example.Entity.Film;
import org.hibernate.SessionFactory;

public class FilmDAO extends DaoGeneric<Film> {
    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }
}
