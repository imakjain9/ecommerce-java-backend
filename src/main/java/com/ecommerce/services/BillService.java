package com.ecommerce.services;

import com.ecommerce.dto.BillDTO;
import com.ecommerce.dto.BillEntryDTO;
import com.ecommerce.entity.Anomalies;
import com.ecommerce.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class BillService {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    CustomerService customerService;

    @Autowired
    SellerService sellerService;

    @Autowired
    PaymentService paymentService;


    private double qtySub = 0.0;

    private BillEntryDTO billEntryDTO;

    public BillDTO gentrateBill(Long customerId) {
        billEntryDTO = null;
        double grandTotal = 0.0;
        List<Subscription> subList = subscriptionService.getSubscriptionByCustomerId(customerId);
        BillDTO billDTO = new BillDTO();
        List<BillEntryDTO> billEntryDTOList = new ArrayList<BillEntryDTO>();
        billDTO.setSellerName(sellerService.getUser((customerService.getRegisteredUser(customerId)).toString()).getFirstName());
        for (Subscription subscription : subList) {
            billEntryDTO = createBillEntryDTO(subscription);
            grandTotal = grandTotal + billEntryDTO.getSubTotal();
            billEntryDTOList.add(billEntryDTO);
        }
        billDTO.setGrandTotal(grandTotal);
        billDTO.setBillEntryDTOList(billEntryDTOList);
        billDTO.setCustomerName(customerService.getCustomerById(customerId).getCustomer_name());

        return billDTO;
    }

    public BillEntryDTO createBillEntryDTO(Subscription subscription) {
        int price = 0;
        double amt = 0;
        BillEntryDTO billEntryDTO = new BillEntryDTO();
        if (subscription.getActive()) {
            long diff = new Date().getTime() - subscription.getPaidUpto().getTime();

            int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            System.out.println("days" + days);
            Set<Anomalies> anomaliesSet = subscription.getAnomalies();
            Set<Anomalies> anomaliesAfterPaidUpto = new HashSet<Anomalies>();
            System.out.println("quantity before for loop : " + qtySub);
            for (Anomalies anomalies : anomaliesSet) {
                if (anomalies.getDate().after(subscription.getPaidUpto())) {

                    price = (int) (price + anomalies.getQuantity() * subscription.getPrice());
                    qtySub = qtySub + anomalies.getQuantity();
                    anomaliesAfterPaidUpto.add(anomalies);
                }

            }
            days = days - anomaliesAfterPaidUpto.size();
            qtySub = days * subscription.getQuantity();
            billEntryDTO.setAnomalies(anomaliesAfterPaidUpto);
            amt = days * subscription.getPrice() * subscription.getQuantity();
        }

        System.out.println("quantity after for loop: " + qtySub);
        billEntryDTO.setPrice(subscription.getPrice());
        billEntryDTO.setItemName(subscription.getItemId().getName());
        billEntryDTO.setSubTotal(price + amt - subscription.getBalance());
        billEntryDTO.setBalance(subscription.getBalance());
        billEntryDTO.setQuantity(qtySub);
        return billEntryDTO;
    }


    public double customerNeedToPay(BillDTO billDTO) {
        return billDTO.getGrandTotal();
    }

}
