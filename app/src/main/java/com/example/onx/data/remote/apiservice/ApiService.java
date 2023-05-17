package com.example.onx.data.remote.apiservice;


import com.example.onx.domain.models.DeliveryBillsItem;
import com.example.onx.domain.models.LoginResponse;

import io.reactivex.rxjava3.core.Single;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("CheckDeliveryLogin")
    Single<LoginResponse> CheckDeliveryLogin(@Body RequestBody requestBody );


    @Headers("Content-Type: application/json")
    @POST("GetDeliveryBillsItems")
    Single<DeliveryBillsItem>GetDeliveryBillsItems(@Body RequestBody requestBody );






}
