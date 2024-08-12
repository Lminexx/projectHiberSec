package org.example.DAO;

import org.example.Entity.FilmText;
import org.hibernate.SessionFactory;

public class FilmTextDao extends DaoGeneric<FilmText> {
    public FilmTextDao(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}
