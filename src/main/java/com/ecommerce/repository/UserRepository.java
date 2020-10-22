package com.ecommerce.repository;

import com.ecommerce.dto.RegisterRequestDTO;
import com.ecommerce.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(RegisterRequestDTO registerRequestDTO){
        User user=new User();
        user.setFirstName(registerRequestDTO.getFirstName());
        user.setEmail(registerRequestDTO.getEmail());
        user.setLastName(registerRequestDTO.getLastName());

//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }
}
