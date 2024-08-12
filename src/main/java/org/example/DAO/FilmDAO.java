package org.example.DAO;

import org.example.Entity.Film;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class FilmDAO extends DaoGeneric<Film> {
    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }

    public Film getNormFilm(int number) {
        Query<Film> query = getSessionFactory().createQuery("select f from Film f where f.film_id = :num",Film.class);
        query.setParameter("num", number);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
