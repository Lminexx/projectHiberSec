package org.example.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DaoGeneric<T> {
    private final Class<T> clazz;
    private final SessionFactory sessionFactory;


    public DaoGeneric(Class<T> clazz, SessionFactory sessionFactory) {
        this.clazz = clazz;
        this.sessionFactory = sessionFactory;
    }

    public T getById(int id) {
        Session session = getSessionFactory();
        return (T) session.get(clazz, id);
    }

    public List<T> getAll(){
        Session session = getSessionFactory();
        Query<T> query = session.createQuery("from " + clazz.getName(), clazz);
        return query.getResultList();
    }

    public List<T> getItems(int off , int cnt){
        Session session = getSessionFactory();
        Query<T> query = session.createQuery("from " + clazz.getName(), clazz);
        query.setFirstResult(off);
        query.setMaxResults(cnt);
        return query.getResultList();
    }

    public T save(T entity){
        Session session = getSessionFactory();
        session.save(entity);
        return entity;
    }

    public T update (T entity){
        Session session = getSessionFactory();
        session.update(entity);
        return entity;
    }

    public void delete(T entity){
        Session session = getSessionFactory();
        session.delete(entity);
    }

    public void deleteById(int id){
        Session session = getSessionFactory();
        T entity = getById(id);
        session.delete(entity);
    }

    protected Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }



}
