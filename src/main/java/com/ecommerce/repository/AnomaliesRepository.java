package com.ecommerce.repository;

import com.ecommerce.entity.Anomalies;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AnomaliesRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public  void  addAnomalies(Anomalies anomalies){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(anomalies);
        session.getTransaction().commit();
        session.close();
    }
}
