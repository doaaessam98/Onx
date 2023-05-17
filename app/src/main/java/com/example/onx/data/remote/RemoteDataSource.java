package com.example.onx.data.remote;

import com.example.onx.domain.models.DeliveryBillsItem;
import com.example.onx.domain.models.LoginResponse;

import io.reactivex.rxjava3.core.Single;
import okhttp3.RequestBody;
import retrofit2.http.Body;

public interface RemoteDataSource {

    Single<LoginResponse> CheckDeliveryLogin(@Body RequestBody requestBody);
    Single<DeliveryBillsItem> GetDeliveryBillsItems(@Body RequestBody requestBody);

}
