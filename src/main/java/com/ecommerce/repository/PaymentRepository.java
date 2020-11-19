package com.ecommerce.repository;

import com.ecommerce.entity.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PaymentRepository {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addPayment(Payment payment){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(payment);
        session.getTransaction().commit();
        session.close();
    }
}
