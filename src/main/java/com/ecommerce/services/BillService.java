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

    public BillDTO gentrateBill(Long customerId){
        List<Subscription> subList=subscriptionService.getSubscriptionByCustomerId(customerId);
        BillDTO billDTO=new BillDTO();
        BillEntryDTO billEntryDTO=new BillEntryDTO();
        List<BillEntryDTO> billEntryDTOList=new ArrayList<BillEntryDTO>();
        int price=0;
        double amt=0;
       double grandTotal=0.0;
       double qtySub=0.0;
       double qtyAnn=0.0;
        for(Subscription subscription: subList){
            long diff = new Date().getTime() - subscription.getPaidUpto().getTime();
            int days= (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            System.out.println("days"+days);
            Set<Anomalies> anomaliesSet= subscription.getAnomalies();
            days=days-anomaliesSet.size();
            billEntryDTO.setItemName(subscription.getItemId().getName());
            qtySub=days*subscription.getQuantity();
            billEntryDTO.setAnomalies(subscription.getAnomalies());
            billDTO.setSellerName(sellerService.getUser((customerService.getRegisteredUser(customerId)).toString()).getFirstName()) ;
            billEntryDTO.setPrice(subscription.getPrice());
            amt= days*subscription.getPrice()*subscription.getQuantity();
            for(Anomalies anomalies: anomaliesSet){
                price= (int) (price+anomalies.getQuantity()*subscription.getPrice());
                qtyAnn=days*anomalies.getQuantity();
            }
            billEntryDTO.setSubTotal(price+amt);

            billEntryDTO.setQuantity(qtySub-qtyAnn);

            grandTotal=grandTotal+price+amt;
            billEntryDTOList.add(billEntryDTO);
        }

        billDTO.setGrandTotal(grandTotal);
        billDTO.setBillEntryDTOList(billEntryDTOList);
        billDTO.setCustomerName(customerService.getCustomerById(customerId).getCustomer_name());
        return billDTO;
    }
}
