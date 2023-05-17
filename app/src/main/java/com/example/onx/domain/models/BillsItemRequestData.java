package com.example.onx.domain.models;

import com.google.gson.Gson;

public class BillsItemRequestData {

    private BillsItemRequestData.Value Value;

    public BillsItemRequestData( String pDlvryNo,String pLangNo, String pProcessFlg) {
        this.Value = new BillsItemRequestData.Value(pDlvryNo,pLangNo,pProcessFlg);
    }

    private static class Value {
        private String P_DLVRY_NO;
        private String P_LANG_NO;
        private String P_PRCSSD_FLG;



        public Value( String pDlvryNo,String pLangNo, String pProcessFlg) {
            this.P_DLVRY_NO = pDlvryNo;
            this.P_LANG_NO = pLangNo;
            this.P_PRCSSD_FLG = pProcessFlg;

        }
    }
    public String convertRequestDataToJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
