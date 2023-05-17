package com.example.onx.domain.repo;

import androidx.datastore.preferences.core.Preferences;

import com.example.onx.domain.models.Data;
import com.example.onx.domain.models.DeliveryBillsItem;
import com.example.onx.domain.models.LoginResponse;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public interface Repository {

    Single<LoginResponse> CheckDeliveryLogin(String lang, String userName , String password);
    Single<DeliveryBillsItem> getDeliveryBillsItems(String lang, String processed_flag);
    Flowable<String> isLogin();
    Single<Preferences> saveUser(Data deliveryData);


    Flowable<String> getLanguage();
    Single<Preferences> saveLanguag(String lang);
}
