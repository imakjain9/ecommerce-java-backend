package com.ecommerce.repository;

import com.ecommerce.dto.SellerTargetDTO;
import com.ecommerce.entity.SellerTarget;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;

public class SellerTargetRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUserProfessionalDetais(SellerTarget sellerTarget) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(sellerTarget);
        session.getTransaction().commit();
        session.close();
    }

 public Double sellerTargetItemQunatity(Long userId,Long itemId){
         Session session = sessionFactory.openSession();
         String sql = "SELECT * FROM SellerTarget WHERE itemId = :itemId & sellerId = :sellerId";
         SQLQuery query = session.createSQLQuery(sql);
         query.addEntity(SellerTarget.class);
         query.setParameter("itemId", itemId);
         query.setParameter("sellerId", userId);
         List<SellerTarget> sellerTargetList = query.list();
         session.close();
         if(sellerTargetList.isEmpty())
             return 0.00;
         return  sellerTargetList.get(0).getTargetQuantity();

 }
    public SellerTarget getSellerTarget(Long userId,Long itemId){
        Session session = sessionFactory.openSession();
        String sql = "SELECT * FROM SellerTarget WHERE itemId = :itemId & sellerId = :sellerId";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(SellerTarget.class);
        query.setParameter("itemId", itemId);
        query.setParameter("sellerId", userId);
        SellerTarget sellerTarget = (SellerTarget) query.list().get(0);
        session.close();
        return sellerTarget;
    }
    public SellerTarget editItemTarget(SellerTarget sellerTarget,Double newQuantity){
        Session session=sessionFactory.openSession();
        sellerTarget.setTargetQuantity(newQuantity);
        session.beginTransaction();
        session.merge(sellerTarget);
        session.getTransaction().commit();
        session.close();
        return sellerTarget;
    }


}
