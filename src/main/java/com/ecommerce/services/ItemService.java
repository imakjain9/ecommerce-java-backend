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

    public List<Item> getItem(){
        return itemRepository.itemList();
    }
}

