package com.ecommerce.services;

import com.ecommerce.dto.SellerTargetDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Item;
import com.ecommerce.entity.Seller;
import com.ecommerce.entity.SellerTarget;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.ItemRepository;
import com.ecommerce.repository.SellerTargetRepository;
import com.ecommerce.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SellerTargetService {

    @Autowired
    private SellerTargetRepository sellerTargetRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CustomerRepository customerRepository;

        public  void addUserProfessionalDetails(SellerTargetDTO sellerTargetDTO,Long user,Long itemId){
            Item item=itemRepository.item(itemId);
            Seller seller=sellerRepository.getUser(user);
        SellerTarget sellerTarget =new SellerTarget();
        sellerTarget.setTargetQuantity(sellerTargetDTO.getTargetQuantity());
        sellerTarget.setSellerId(seller);
        sellerTarget.setItemId(item);
         sellerTargetRepository.addUserProfessionalDetais(sellerTarget);
    }

    public Double sellerTargetItemQunatity(Long customerId,Long itemId){
        Customer customer=customerRepository.getCustomerById(customerId);
        return  sellerTargetRepository.sellerTargetItemQunatity(customer.getRegistered_seller().getId(),itemId);
    }

}
