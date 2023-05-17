package com.example.onx.domain.usecase;

import com.example.onx.domain.models.Data;
import com.example.onx.domain.models.DeliveryBillsItem;
import com.example.onx.domain.models.LoginResponse;
import com.example.onx.domain.repo.Repository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;


public class UserLoginUseCase {

    private final Repository repository;

    @Inject
    public UserLoginUseCase(Repository repository) {
        this.repository = repository;
    }

     public Single<LoginResponse> CheckDeliveryLogin(String lang , String userName, String password){
        return repository.CheckDeliveryLogin(lang,userName,password);
    }


    public Flowable<String> isLogin(){
        return repository.isLogin();
    }

    public void saveUser(Data deliveryData){
        repository.saveUser(deliveryData);
    }



}
