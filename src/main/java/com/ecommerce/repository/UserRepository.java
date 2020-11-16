package com.ecommerce.repository;

import com.ecommerce.dto.RegisterRequestDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;

public class UserRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(RegisterRequestDTO registerRequestDTO){
        User user=new User();
        user.setId(registerRequestDTO.getId());
        user.setFirstName(registerRequestDTO.getFirstName());
        user.setEmail(registerRequestDTO.getEmail());
        user.setLastName(registerRequestDTO.getLastName());
        user.setPhoneNumber(registerRequestDTO.getPhoneNumber());
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public List<User> list() {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("from User").list();
        session.close();
        return users;
    }

    public  User getUser(Long id){
        Session session = sessionFactory.openSession();
        User user=session.get(User.class, id);
        session.close();
        return user;
    }
    public Set<Customer> getUserCustomers(Long id){
        Session session = sessionFactory.openSession();
        User user=session.get(User.class, id);
        session.close();
        return  user.getCustomers();
    }

}
