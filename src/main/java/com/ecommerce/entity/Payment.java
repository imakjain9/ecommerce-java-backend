package com.ecommerce.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer",nullable=false)
    private  Customer customer;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date date;
    private Double amount;

    private double balance;

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

    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }
}
