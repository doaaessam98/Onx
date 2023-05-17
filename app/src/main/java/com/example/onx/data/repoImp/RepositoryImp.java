package com.example.onx.data.repoImp;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.rxjava3.RxDataStore;

import com.example.onx.data.remote.RemoteDataSource;
import com.example.onx.domain.models.BillsItemRequestData;
import com.example.onx.domain.models.Data;
import com.example.onx.domain.models.DeliveryBillsItem;
import com.example.onx.domain.models.LoginResponse;
import com.example.onx.domain.models.UserRequestData;
import com.example.onx.domain.repo.Repository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RepositoryImp  implements Repository {

    private final RemoteDataSource remoteDataSource;
    private final RxDataStore<Preferences> dataStore;
    Preferences.Key<String> KEY = PreferencesKeys.stringKey("user");
    Preferences.Key<String> LAN_KEY = PreferencesKeys.stringKey("lang");
    String language;

    @Inject
    public RepositoryImp(RemoteDataSource remoteDataSource,RxDataStore<Preferences> userLoginStatus) {
        this.remoteDataSource = remoteDataSource;
        this.dataStore = userLoginStatus;
        getLang().subscribe(language -> {
                   this.language = language;
                }, throwable -> {

                });

    }


    @Override
    public Single<LoginResponse> CheckDeliveryLogin(String lang, String userName, String password) {
        UserRequestData requestData = new UserRequestData(language, userName, password);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),requestData.convertRequestDataToJson());
        return remoteDataSource.CheckDeliveryLogin(requestBody);
    }

    @Override
    public Single<DeliveryBillsItem> getDeliveryBillsItems(String lang, String processed_flag) {
        BillsItemRequestData requestData = new BillsItemRequestData("1010",language, processed_flag);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),requestData.convertRequestDataToJson());
        return remoteDataSource.GetDeliveryBillsItems(requestBody);
    }


    @Override
    public Flowable<String> isLogin() {

        return dataStore.data().map(preferences -> preferences.get(KEY));
    }




    @Override
    public Single<Preferences> saveUser(Data deliveryData) {
        Single<Preferences> updateResult =  dataStore.updateDataAsync(prefsIn -> {
            MutablePreferences mutablePreferences = prefsIn.toMutablePreferences();
            mutablePreferences.set(KEY,deliveryData.getDeliveryName());
            return Single.just(mutablePreferences);
        });
        return updateResult;
    }


    @Override
    public Flowable<String> getLanguage() {
        return dataStore.data().map(preferences -> preferences.get(LAN_KEY));
    }

    public Single<String> getLang() {
        return dataStore.data()
                .map(preferences -> preferences.get(LAN_KEY))
                .firstOrError();
    }

    @Override
    public Single<Preferences> saveLanguag(String lang) {
        Single<Preferences> updateResult =  dataStore.updateDataAsync(prefsIn -> {
            MutablePreferences mutablePreferences = prefsIn.toMutablePreferences();
            String currentLang = prefsIn.get(LAN_KEY);

            mutablePreferences.set(LAN_KEY,currentLang!=null?lang:"1");
            return Single.just(mutablePreferences);
        });
        return updateResult;
    }
}



