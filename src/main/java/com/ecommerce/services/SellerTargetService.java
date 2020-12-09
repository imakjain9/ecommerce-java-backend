package com.ecommerce.services;

import com.ecommerce.dto.SellerTargetDTO;
import com.ecommerce.entity.Item;
import com.ecommerce.entity.Seller;
import com.ecommerce.entity.SellerTarget;
import com.ecommerce.repository.ItemRepository;
import com.ecommerce.repository.SellerTargetRepository;
import com.ecommerce.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerTargetService {

    @Autowired
    private SellerTargetRepository sellerTargetRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ItemRepository itemRepository;

        public  void addUserProfessionalDetails(SellerTargetDTO sellerTargetDTO,Long user){
            Item item=itemRepository.item(sellerTargetDTO.getSellerId());
            Seller seller=sellerRepository.getUser(user);
        SellerTarget sellerTarget =new SellerTarget();
        sellerTarget.setTargetQuantity(sellerTargetDTO.getTargetQuantity());
        sellerTarget.setSellerId(seller);
        sellerTarget.setItemId(item);
         sellerTargetRepository.addUserProfessionalDetais(sellerTarget);
    }



}
