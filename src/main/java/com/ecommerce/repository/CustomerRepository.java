package com.ecommerce.repository;



import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Subscription;
import com.ecommerce.entity.Seller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class CustomerRepository {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }

    public List<Customer> customerList(){
      Session session=sessionFactory.openSession();
      List<Customer> customers=session.createQuery("from Customer").list();
      session.close();
      return customers;
    }

    public Customer getCustomerById(Long id){
        Session session=sessionFactory.openSession();
        Customer customer=session.get(Customer.class,id);
        session.close();
        return customer;
    }
    public Set<Subscription> getCustomerSubscriptions(Long id){
        Session session=sessionFactory.openSession();
        Customer customer=session.get(Customer.class,id);
        session.close();
        return customer.getSubscriptions();
    }
    public Long getCustomerRegisteredUserId(Long id){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Customer customer=session.get(Customer.class,id);
     session.getTransaction().commit();
       session.close();
        Seller seller = customer.getRegistered_seller();
        return seller.getId();
    }

    public Long getIdByCustomerName(String customerName){
        Session session=sessionFactory.openSession();
        Query query = session.createQuery("SELECT id FROM Customer WHERE customer_name =:customer_name");
        query.setParameter("customer_name", customerName);
        Long res;
        res = (long) query.getFirstResult();
        session.close();
        return res;
    }
}
