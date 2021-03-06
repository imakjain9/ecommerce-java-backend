package com.ecommerce.repository;
import org.hibernate.query.Query;
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
        //session.saveOrUpdate(item);
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
        // get the current hibernate session
        Session currentSession = sessionFactory.openSession();
        currentSession.beginTransaction();
        // delete object with primary key
        Query theQuery = currentSession.createQuery("delete from Item where id=:itemId");
        theQuery.setParameter("itemId", id);
        theQuery.executeUpdate();
        currentSession.getTransaction().commit();
        currentSession.close();
    }

    public Item editItem(ItemAddDTO itemAddDTO,String id){
        //Item item=new ItemRepository().item(Long.parseLong(id));
        Item item=new Item();
        Session session=sessionFactory.openSession();
        item.setName(itemAddDTO.getName());
        item.setPrice(itemAddDTO.getPrice());
        item.setUrl(itemAddDTO.getUrl());
        item.setId(Long.parseLong(id));
        session.beginTransaction();
        session.merge(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }





}
