package com.example.onx.app.di;


import com.example.onx.data.remote.apiservice.ApiService;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import io.reactivex.rxjava3.schedulers.Schedulers;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {

    @Provides
    @Singleton public HttpLoggingInterceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor logging) {
        return new OkHttpClient.Builder()
                 .addInterceptor(logging)
                .build();
    }

    @Provides
    @Singleton
    public Gson gson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }

    @Provides
    @Singleton
    public GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }



    @Provides
    public static Retrofit provideRetrofit(
            GsonConverterFactory converterFactory, OkHttpClient okHttpClient
    ) {


        CallAdapter.Factory rxAdapter = RxJava3CallAdapterFactory.create();

        return new Retrofit.Builder()
                .baseUrl("http://mapp.yemensoft.net/OnyxDeliveryService/Service.svc/")
                .addConverterFactory(converterFactory)
                .client(okHttpClient)
                .addCallAdapterFactory(rxAdapter)
                .build();

    }

    @Provides
    @Singleton
    public  ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }


}






