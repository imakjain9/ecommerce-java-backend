package com.ecommerce.repository;

import com.ecommerce.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AdminRepository {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Boolean userAuthantication(String userEmail,String userPassword){
        Session session=sessionFactory.openSession();
        User user=session.get(User.class,userEmail);
        session.close();
        if(user==null)
            return false;
       if(user.getPassword().equals(userPassword))
           return  true;
       return false;
    }

}
