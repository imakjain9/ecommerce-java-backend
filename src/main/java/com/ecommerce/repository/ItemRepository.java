package com.ecommerce.repository;

import com.ecommerce.dto.ItemAddDTO;
import com.ecommerce.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ItemRepository {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addItem(ItemAddDTO itemAddDTO){
        Item item=new Item();
        item.setId(itemAddDTO.getId());
        item.setName(itemAddDTO.getName());
        item.setPrice(itemAddDTO.getPrice());
        item.setUrl(itemAddDTO.getUrl());

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
    }
    public List<Item> itemList(){
        Session session = sessionFactory.openSession();
        List<Item> items=session.createQuery("from Item").list();
        session.close();
        return  items;
    }
}
