package com.ecommerce.dto;

public class CustomerRegisterDTO {
    private Long id;
    private String customer_name;
    private String customer_email;
    private String customer_phone;
    private String customer_address;
    private String customer_type;
    private Long registered_user;

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(String customer_type) {
        this.customer_type = customer_type;
    }

    public Long getRegistered_user() {
        return registered_user;
    }

    public void setRegistered_user(Long registered_user) {
        this.registered_user = registered_user;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
}
