package com.ecommerce.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String email;
    private String firstName;
    private String lastName;
    private  String phoneNumber;
    private String password;
    @OneToMany(mappedBy="registered_seller",fetch = FetchType.EAGER)
    private Set<Customer> customers;

    @OneToMany(mappedBy = "sellerId",fetch = FetchType.LAZY)
    private Set<SellerTarget> sellerTarget;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Set<SellerTarget> getSellerTarget() {
        return sellerTarget;
    }

    public void setSellerTarget(Set<SellerTarget> sellerTarget) {
        this.sellerTarget = sellerTarget;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
