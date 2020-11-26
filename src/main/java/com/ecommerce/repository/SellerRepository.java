package com.ecommerce.repository;

import com.ecommerce.dto.RegisterRequestDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Seller;
import com.ecommerce.entity.SellerTarget;
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

    public SellerTarget getUserProfessionalDetails(Long userId){
        Session session = sessionFactory.openSession();
        Seller seller =session.get(Seller.class, userId);
        session.close();
        return seller.getSellerTarget();

    }

}
