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
    public Item item(Long id){
       Session session=sessionFactory.openSession();
       Item item=session.get(Item.class,id);
      // Item item=session.createQuery("form Item i" + "where i.id=" ,id);
       session.close();
       return item;
    }
    public  void deleteItem(Long id){
        Session session=sessionFactory.openSession();
        Item item=session.get(Item.class,id);
        session.delete(item);
        session.close();
    }
    /*
    public Item editItem(Long id,String name,Double price,String ur){
        Session session=sessionFactory.openSession();
        Item item=session.get(Item.class,id);
        item.setName(name);
        item.setPrice(price);
        item.setUrl(url);
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }
    */
}
