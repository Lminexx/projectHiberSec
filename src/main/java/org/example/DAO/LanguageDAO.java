package org.example.DAO;

import org.example.Entity.Language;
import org.hibernate.SessionFactory;

public class LanguageDAO extends DaoGeneric<Language> {
    public LanguageDAO(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }
}
