package com.ecommerce.entity;

import javax.persistence.*;
import java.util.Date;

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer")
    private  Customer customer;

    private Date date;
    private Double amount;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
