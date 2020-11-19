package com.ecommerce.repository;

import com.ecommerce.dto.CustomerRegisterDTO;
import com.ecommerce.dto.RegisterRequestDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Subscription;
import com.ecommerce.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

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
    public List<Subscription> getCustomerSubscriptions(Long id){
        Session session=sessionFactory.openSession();
        Customer customer=session.get(Customer.class,id);
        session.close();
        return customer.getSubscriptions();
    }

}
