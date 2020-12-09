package com.ecommerce.repository;

import com.ecommerce.dto.RegisterRequestDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Seller;
import com.ecommerce.entity.SellerTarget;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;

public class SellerRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(RegisterRequestDTO registerRequestDTO){
        Seller seller =new Seller();
        seller.setId(registerRequestDTO.getId());
        seller.setFirstName(registerRequestDTO.getFirstName());
        seller.setEmail(registerRequestDTO.getEmail());
        seller.setLastName(registerRequestDTO.getLastName());
        seller.setPhoneNumber(registerRequestDTO.getPhoneNumber());
        seller.setPassword(registerRequestDTO.getPassword());
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(seller);
        session.getTransaction().commit();
        session.close();
    }

    public List<Seller> list() {
        Session session = sessionFactory.openSession();
        List<Seller> sellers = session.createQuery("from Seller").list();
        session.close();
        return sellers;
    }

    public Seller getUser(Long id){
        Session session = sessionFactory.openSession();
        Seller seller =session.get(Seller.class, id);
        session.close();
        return seller;
    }
    public Set<Customer> getUserCustomers(Long id){
        Session session = sessionFactory.openSession();
        Seller seller =session.get(Seller.class, id);
        session.close();
        return  seller.getCustomers();
    }

    public Set<SellerTarget> getUserProfessionalDetails(Long userId){
        Session session = sessionFactory.openSession();
        Seller seller =session.get(Seller.class, userId);
        session.close();
        return seller.getSellerTarget();

    }
    public Boolean sellerAuthantication(String sellerEmail,String sellerPassword){
        Session session = sessionFactory.openSession();
        String sql = "SELECT * FROM Seller WHERE email = :sellerEmail";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Seller.class);
        query.setParameter("sellerEmail", sellerEmail);
        Seller seller =(Seller) query.list().get(0);
        session.close();
        if(seller==null)
            return false;
        if(seller.getPassword().equals(sellerPassword))
            return  true;
       return false;
    }

    public Long sellerIdByEmail(String sellerEmail){
        Session session = sessionFactory.openSession();
        String sql = "SELECT * FROM Seller WHERE email = :sellerEmail";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Seller.class);
        query.setParameter("sellerEmail", sellerEmail);
        Seller seller =(Seller) query.list().get(0);
        session.close();
        return  seller.getId();
    }

}
