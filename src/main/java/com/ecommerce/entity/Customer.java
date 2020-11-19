package com.ecommerce.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customer_name;
    private String customer_email;
    private String customer_phone;
    private String customer_address;
    private String customer_type;

    @ManyToOne
    @JoinColumn(name="registered_user", nullable=false)
    private User registered_user;

    @OneToMany(mappedBy="customer_id",fetch = FetchType.EAGER)
    private List<Subscription> subscriptions = new ArrayList<Subscription>();

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_emai) {
        this.customer_email = customer_emai;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_address() {return customer_address;}

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(String customer_type) {
        this.customer_type = customer_type;
    }

    public User getRegistered_user() {
        return registered_user;
    }

    public void setRegistered_user(User registered_user) {
        this.registered_user = registered_user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
