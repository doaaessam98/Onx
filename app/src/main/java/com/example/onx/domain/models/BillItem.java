package com.example.onx.domain.models;

import java.text.DecimalFormat;

public class BillItem {
    private String itemNumber;
    private String itemDate;
    private String itemStatus;
    private String itemPrice;

    public BillItem(String itemNumber, String itemDate, String itemStatus, String itemPrice) {
        this.itemNumber = itemNumber;
        this.itemDate = itemDate;
        this.itemStatus = itemStatus;
        this.itemPrice = itemPrice;
    }

    public BillItem() {
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemDate() {
        return itemDate;
    }

    public void setItemDate(String itemDate) {
        this.itemDate = itemDate;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        String status ="";
        switch (itemStatus){
           case "1":
                status= "Delivered";
                break;
            case "2":
                status = "Partial Return";
                break;
            case "3":
                status = "Full Returned";
                break;
        };
        this.itemStatus = status;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        double d = Double.parseDouble(itemPrice);

        this.itemPrice =  new DecimalFormat("##.##").format(d).toString();;
    }
}
