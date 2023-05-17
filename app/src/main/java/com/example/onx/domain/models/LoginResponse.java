package com.example.onx.domain.models;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("Data")
    private Data data;

    @SerializedName("Result")
    private Result result;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
