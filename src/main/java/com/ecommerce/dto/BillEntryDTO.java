package com.ecommerce.dto;

import com.ecommerce.entity.Anomalies;

import java.util.List;
import java.util.Set;

public class BillEntryDTO {

    String itemName;

    Double price;

    Double quantity;

    Double subTotal;

    Set<Anomalies> anomalies;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Set<Anomalies> getAnomalies() {
        return anomalies;
    }

    public void setAnomalies(Set<Anomalies> anomalies) {
        this.anomalies = anomalies;
    }
}
