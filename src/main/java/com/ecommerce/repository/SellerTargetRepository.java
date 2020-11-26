package com.ecommerce.repository;

import com.ecommerce.entity.SellerTarget;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SellerTargetRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUserProfessionalDetais(SellerTarget sellerTarget) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(sellerTarget);
        session.getTransaction().commit();
        session.close();

    }


}
