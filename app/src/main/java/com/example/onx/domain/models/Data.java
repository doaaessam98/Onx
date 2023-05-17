package com.example.onx.domain.models;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("DeliveryName")
    private String deliveryName;

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }
}
