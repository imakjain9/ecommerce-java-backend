package com.ecommerce.dto;

import java.util.List;

public class BillDTO {

    String customerName;

    double grandTotal;

   List<BillEntryDTO> billEntryDTOList;

    String sellerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public List<BillEntryDTO> getBillEntryDTOList() {
        return billEntryDTOList;
    }

    public void setBillEntryDTOList(List<BillEntryDTO> billEntryDTOList) {
        this.billEntryDTOList = billEntryDTOList;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
