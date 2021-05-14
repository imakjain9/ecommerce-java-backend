package com.ecommerce.services;

import com.ecommerce.dto.ItemAddDTO;
import com.ecommerce.entity.Item;
import com.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public void register(ItemAddDTO itemAddDTO){
        itemRepository.addItem(itemAddDTO);
    }

    public List<Item> getItems(){
        return itemRepository.itemList();
    }

    public Item getItem(String id){
        Long itemid=Long.parseLong(id);
        return  itemRepository.item(itemid); }

    public void deleteItem(String id){
        Long itemid=Long.parseLong(id);
        System.out.println("this is from item service item id: " + itemid);
         itemRepository.deleteItem(itemid);
    }

    public Item updateItem(ItemAddDTO itemAddDTO,String id){
        return itemRepository.editItem(itemAddDTO,id);
    }
}

