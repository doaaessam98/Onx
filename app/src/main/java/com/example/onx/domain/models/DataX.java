package com.example.onx.domain.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataX {
    @SerializedName("DeliveryBills")
    private List<DeliveryBill> deliveryBills;

    public List<DeliveryBill> getDeliveryBills() {
        return deliveryBills;
    }

    public void setDeliveryBills(List<DeliveryBill> deliveryBills) {
        this.deliveryBills = deliveryBills;
    }
}
