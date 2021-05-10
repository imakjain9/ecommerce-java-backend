package com.ecommerce.services;

import com.ecommerce.dto.BillDTO;
import com.ecommerce.dto.BillEntryDTO;
import com.ecommerce.entity.Anomalies;
import com.ecommerce.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class BillService {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    CustomerService customerService;

    @Autowired
    SellerService sellerService;

   private int price=0;
   private double amt=0;
    private double grandTotal=0.0;
    private double qtySub=0.0;


    public BillDTO gentrateBill(Long customerId){
        List<Subscription> subList=subscriptionService.getSubscriptionByCustomerId(customerId);
        BillDTO billDTO=new BillDTO();
        List<BillEntryDTO> billEntryDTOList=new ArrayList<BillEntryDTO>();
        billDTO.setSellerName(sellerService.getUser((customerService.getRegisteredUser(customerId)).toString()).getFirstName()) ;
        for(Subscription subscription: subList){
            BillEntryDTO billEntryDTO=createBillEntryDTO(subscription);
            grandTotal=grandTotal+billEntryDTO.getSubTotal();
            billEntryDTOList.add(billEntryDTO);
        }
        billDTO.setGrandTotal(grandTotal);
        billDTO.setBillEntryDTOList(billEntryDTOList);
        billDTO.setCustomerName(customerService.getCustomerById(customerId).getCustomer_name());
        return billDTO;
    }

    public BillEntryDTO createBillEntryDTO(Subscription subscription){
        long diff = new Date().getTime() - subscription.getPaidUpto().getTime();
        int days= (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        System.out.println("days"+days);
        Set<Anomalies> anomaliesSet= subscription.getAnomalies();
        days=days-anomaliesSet.size();
        qtySub=qtySub+days*subscription.getQuantity();
        BillEntryDTO billEntryDTO=new BillEntryDTO();
        amt= days*subscription.getPrice()*subscription.getQuantity();
        for(Anomalies anomalies: anomaliesSet){
            price= (int) (price+anomalies.getQuantity()*subscription.getPrice());
            qtySub=qtySub+anomalies.getQuantity();
        }
        billEntryDTO.setAnomalies(subscription.getAnomalies());
        billEntryDTO.setPrice(subscription.getPrice());
        billEntryDTO.setItemName(subscription.getItemId().getName());
        billEntryDTO.setSubTotal(price+amt);
        billEntryDTO.setQuantity(qtySub);
        return  billEntryDTO;
    }



}
