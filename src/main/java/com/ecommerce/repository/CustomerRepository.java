package com.ecommerce.repository;

import com.ecommerce.dto.CustomerRegisterDTO;
import com.ecommerce.dto.RegisterRequestDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CustomerRepository {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCustomer(CustomerRegisterDTO customerRegisterDTO) {

        Customer customer=new Customer();
        customer.setId(customerRegisterDTO.getId());
        customer.setCustomer_name(customerRegisterDTO.getCustomer_name());
        System.out.println(customerRegisterDTO.getCustomer_email());
        customer.setCustomer_email(customerRegisterDTO.getCustomer_email());
        customer.setCustomer_address(customerRegisterDTO.getCustomer_address());
        customer.setCustomer_phone(customerRegisterDTO.getCustomer_phone());
        customer.setCustomer_type(customerRegisterDTO.getCustomer_type());
        customer.setRegistered_user(customerRegisterDTO.getRegistered_user());
        System.out.println(customerRegisterDTO.getRegistered_user().getFirstName());
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
}
