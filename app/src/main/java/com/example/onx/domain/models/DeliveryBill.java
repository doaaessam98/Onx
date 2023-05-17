package com.example.onx.domain.models;


import com.google.gson.annotations.SerializedName;

public class DeliveryBill {
    @SerializedName("BILL_AMT")
    private String bILLAMT;

    @SerializedName("BILL_DATE")
    private String bILLDATE;

    @SerializedName("BILL_NO")
    private String bILLNO;

    @SerializedName("BILL_SRL")
    private String bILLSRL;

    @SerializedName("BILL_TIME")
    private String bILLTIME;

    @SerializedName("BILL_TYPE")
    private String bILLTYPE;

    @SerializedName("CSTMR_ADDRSS")
    private String cSTMRADDRSS;

    @SerializedName("CSTMR_APRTMNT_NO")
    private String cSTMRAPRTMNTNO;

    @SerializedName("CSTMR_BUILD_NO")
    private String cSTMRBUILDNO;

    @SerializedName("CSTMR_FLOOR_NO")
    private String cSTMRFLOORNO;

    @SerializedName("CSTMR_NM")
    private String cSTMRNM;

    @SerializedName("DLVRY_AMT")
    private String dLVRYAMT;

    @SerializedName("DLVRY_STATUS_FLG")
    private String dLVRYSTATUSFLG;

    @SerializedName("LATITUDE")
    private String lATITUDE;

    @SerializedName("LONGITUDE")
    private String lONGITUDE;

    @SerializedName("MOBILE_NO")
    private String mOBILENO;

    @SerializedName("RGN_NM")
    private String rGNNM;

    @SerializedName("TAX_AMT")
    private String tAXAMT;

    public String getBILLAMT() {
        return bILLAMT;
    }

    public void setBILLAMT(String bILLAMT) {
        this.bILLAMT = bILLAMT;
    }

    public String getBILLDATE() {
        return bILLDATE;
    }

    public void setBILLDATE(String bILLDATE) {
        this.bILLDATE = bILLDATE;
    }

    public String getBILLNO() {
        return bILLNO;
    }

    public void setBILLNO(String bILLNO) {
        this.bILLNO = bILLNO;
    }

    public String getBILLSRL() {
        return bILLSRL;
    }

    public void setBILLSRL(String bILLSRL) {
        this.bILLSRL = bILLSRL;
    }

    public String getBILLTIME() {
        return bILLTIME;
    }

    public void setBILLTIME(String bILLTIME) {
        this.bILLTIME = bILLTIME;
    }

    public String getBILLTYPE() {
        return bILLTYPE;
    }

    public void setBILLTYPE(String bILLTYPE) {
        this.bILLTYPE = bILLTYPE;
    }

    public String getCSTMRADDRSS() {
        return cSTMRADDRSS;
    }

    public void setCSTMRADDRSS(String cSTMRADDRSS) {
        this.cSTMRADDRSS = cSTMRADDRSS;
    }

    public String getCSTMRAPRTMNTNO() {
        return cSTMRAPRTMNTNO;
    }

    public void setCSTMRAPRTMNTNO(String cSTMRAPRTMNTNO) {
        this.cSTMRAPRTMNTNO = cSTMRAPRTMNTNO;
    }

    public String getCSTMRBUILDNO() {
        return cSTMRBUILDNO;
    }

    public void setCSTMRBUILDNO(String cSTMRBUILDNO) {
        this.cSTMRBUILDNO = cSTMRBUILDNO;
    }

    public String getCSTMRFLOORNO() {
        return cSTMRFLOORNO;
    }

    public void setCSTMRFLOORNO(String cSTMRFLOORNO) {
        this.cSTMRFLOORNO = cSTMRFLOORNO;
    }

    public String getCSTMRNM() {
        return cSTMRNM;
    }

    public void setCSTMRNM(String cSTMRNM) {
        this.cSTMRNM = cSTMRNM;
    }

    public String getDLVRYAMT() {
        return dLVRYAMT;
    }

    public void setDLVRYAMT(String dLVRYAMT) {
        this.dLVRYAMT = dLVRYAMT;
    }

    public String getDLVRYSTATUSFLG() {
        return dLVRYSTATUSFLG;
    }

    public void setDLVRYSTATUSFLG(String dLVRYSTATUSFLG) {
        this.dLVRYSTATUSFLG = dLVRYSTATUSFLG;
    }

    public String getLATITUDE() {
        return lATITUDE;
    }

    public void setLATITUDE(String lATITUDE) {
        this.lATITUDE = lATITUDE;
    }

    public String getLONGITUDE() {
        return lONGITUDE;
    }

    public void setLONGITUDE(String lONGITUDE) {
        this.lONGITUDE = lONGITUDE;
    }

    public String getMOBILENO() {
        return mOBILENO;
    }

    public void setMOBILENO(String mOBILENO) {
        this.mOBILENO = mOBILENO;
    }

    public String getRGNNM() {
        return rGNNM;
    }

    public void setRGNNM(String rGNNM) {
        this.rGNNM = rGNNM;
    }

    public String getTAXAMT() {
        return tAXAMT;
    }

    public void setTAXAMT(String tAXAMT) {
        this.tAXAMT = tAXAMT;
    }
}