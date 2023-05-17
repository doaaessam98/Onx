package com.example.onx.domain.models;


import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("ErrMsg")
    private String errMsg;

    @SerializedName("ErrNo")
    private int errNo;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public int getErrNo() {
        return errNo;
    }

    public void setErrNo(int errNo) {
        this.errNo = errNo;
    }
}

