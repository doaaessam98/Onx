package com.example.onx.domain.models;

import com.google.gson.annotations.SerializedName;

public class DeliveryBillsItem {
    @SerializedName("Data")
    private DataX data;

    @SerializedName("Result")
    private Result result;

    public DataX getData() {
        return data;
    }

    public void setData(DataX data) {
        this.data = data;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
