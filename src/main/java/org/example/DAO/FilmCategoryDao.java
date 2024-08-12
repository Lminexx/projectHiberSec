package org.example.DAO;

import org.example.Entity.FilmCategory;
import org.hibernate.SessionFactory;

public class FilmCategoryDao extends DaoGeneric<FilmCategory> {
    public FilmCategoryDao(SessionFactory sessionFactory) {
        super(FilmCategory.class, sessionFactory);
    }
}
