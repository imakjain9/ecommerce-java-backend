package com.ecommerce.services;

import com.ecommerce.dto.RegisterRequestDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Seller;
import com.ecommerce.entity.SellerTarget;
import com.ecommerce.repository.SellerTargetRepository;
import com.ecommerce.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private SellerTargetRepository sellerTargetRepository;

    public void register(RegisterRequestDTO registerRequestDTO){
        sellerRepository.addUser(registerRequestDTO);
    }

    public List<Seller> getUsers(){
        return sellerRepository.list();
    }

    public Seller getUser(String userid){
        Long id=Long.parseLong(userid);
        return sellerRepository.getUser(id);
    }
    public Set<Customer> getUserCustomers(Long id) {
        return sellerRepository.getUserCustomers(id);
    }

    public SellerTarget getUserTargetMilkQuantity(Long userId){
        return  sellerRepository.getUserProfessionalDetails(userId);
    }

}
