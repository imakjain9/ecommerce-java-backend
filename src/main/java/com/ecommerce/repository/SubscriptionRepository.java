package com.ecommerce.repository;

import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Subscription;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SubscriptionRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addSubscription(Subscription subscription){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(subscription);
        session.getTransaction().commit();
        session.close();
    }

    public Subscription getSubscriptionById(Long id){
        Session session=sessionFactory.openSession();
        Subscription subscription=session.get(Subscription.class,id);
        session.close();
        return subscription;
    }

}
