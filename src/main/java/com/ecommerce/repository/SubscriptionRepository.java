package com.ecommerce.repository;

import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Subscription;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

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


    public List<Subscription> getSubscriptionByCustomerAndItem(Long customerId,Long itemId){
        Session session = sessionFactory.openSession();
        String sql = "SELECT * FROM Subscription WHERE customer_id=:customerId and itemId=:itemId";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Subscription.class);
        query.setParameter("customerId",customerId );
        query.setParameter("itemId",itemId );
        List<Subscription> subscriptions =query.list();
        session.close();
        return subscriptions;
    }

    public void removeSubscription(Subscription subscription){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        subscription.setActive(false);
        session.update(subscription);
        session.getTransaction().commit();
        session.close();
    }
}
