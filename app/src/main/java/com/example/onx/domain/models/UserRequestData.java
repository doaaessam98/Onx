package com.example.onx.domain.models;


import com.google.gson.Gson;

public class UserRequestData {
    private Value Value;

    public UserRequestData(String pLangNo, String pDlvryNo, String pPsswrd) {
        this.Value = new Value(pLangNo, pDlvryNo, pPsswrd);
    }

    private static class Value {
        private String P_LANG_NO;
        private String P_DLVRY_NO;
        private String P_PSSWRD;

        public Value(String pLangNo, String pDlvryNo, String pPsswrd) {
            this.P_LANG_NO = pLangNo;
            this.P_DLVRY_NO = pDlvryNo;
            this.P_PSSWRD = pPsswrd;
        }
    }
    public String convertRequestDataToJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

