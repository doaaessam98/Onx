package com.example.onx.data.remote;

import com.example.onx.data.remote.apiservice.ApiService;
import com.example.onx.domain.models.DeliveryBillsItem;
import com.example.onx.domain.models.LoginResponse;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;
import okhttp3.RequestBody;

public class RemoteDataSourceImp implements RemoteDataSource {

    private final ApiService apiService;
    @Inject
    public RemoteDataSourceImp(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<LoginResponse> CheckDeliveryLogin(RequestBody requestBody) {
        return apiService.CheckDeliveryLogin(requestBody);
    }

    @Override
    public Single<DeliveryBillsItem> GetDeliveryBillsItems(RequestBody requestBody) {
        return apiService.GetDeliveryBillsItems(requestBody);
    }
}
