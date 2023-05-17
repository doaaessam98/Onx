package com.example.onx.app.di;


import android.content.Context;

import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.rxjava3.RxPreferenceDataStoreBuilder;
import androidx.datastore.rxjava3.RxDataStore;

import com.example.onx.data.remote.RemoteDataSource;
import com.example.onx.data.remote.RemoteDataSourceImp;
import com.example.onx.data.repoImp.RepositoryImp;
import com.example.onx.domain.repo.Repository;


import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public interface AppModule {


    @Binds
    public abstract Repository repository(RepositoryImp repositoryImpl);

    @Binds
    public abstract RemoteDataSource remoteDataSource(RemoteDataSourceImp remoteDataSourceImp);


    @Provides
    @Singleton
    public static RxDataStore<Preferences> provideDataStore(@ApplicationContext Context context) {
        return new RxPreferenceDataStoreBuilder(context, "my_data_store").build();
    }





}
