package com.ecommerce.repository;

import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Payment;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;

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
/*
    public double getBalanceAmountByCustomerId(Customer customer){
        Payment payment=null;
        Session session=sessionFactory.openSession();
        String sql = "SELECT * FROM Payment WHERE customer= :customer";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Payment.class);
        query.setParameter("customer", customer);
        payment =(Payment) query.uniqueResult();
        session.close();
        if(payment==null)
            return 0.0;

        return payment.getBalance();
    }


*/
    public double getBalanceAmountByCustomerId(Customer customer){
        Session session=sessionFactory.openSession();

        Query query = session.createQuery("SELECT pay.balance FROM Payment pay WHERE pay.customer=:customer");
        query.setParameter("customer", customer);
        query.getFirstResult();
    }






}
