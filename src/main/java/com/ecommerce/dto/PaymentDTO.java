package com.ecommerce.dto;

import java.util.Date;

public class PaymentDTO {


    private Long customer;
    private Date date;
    private Double amount;

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
