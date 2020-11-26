package com.ecommerce.repository;

import org.hibernate.SessionFactory;

public class AdminRepository {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
