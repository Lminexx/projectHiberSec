package org.example.DAO;

import org.example.Entity.Category;
import org.hibernate.SessionFactory;

public class CategoryDAO extends DaoGeneric<Category> {
    public CategoryDAO(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}
