package com.ecommerce.services;

import com.ecommerce.dto.SellerTargetDTO;
import com.ecommerce.entity.SellerTarget;
import com.ecommerce.repository.SellerTargetRepository;
import com.ecommerce.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerTargetService {

    @Autowired
    private SellerTargetRepository sellerTargetRepository;

    private SellerRepository sellerRepository;

        public  void addUserProfessionalDetails(SellerTargetDTO sellerTargetDTO){
        SellerTarget sellerTarget =new SellerTarget();
        sellerTarget.setTargetMilkQuantity(sellerTargetDTO.getTargetMilkQuantity());
         sellerTargetRepository.addUserProfessionalDetais(sellerTarget);
    }



}
