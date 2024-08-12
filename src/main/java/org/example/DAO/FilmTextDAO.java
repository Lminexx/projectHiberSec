package org.example.DAO;

import org.example.Entity.FilmText;
import org.hibernate.SessionFactory;

public class FilmTextDAO extends DaoGeneric<FilmText> {
    public FilmTextDAO(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}
