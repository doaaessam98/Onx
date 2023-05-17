package com.example.onx.app.ui.splash;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.onx.domain.models.Data;
import com.example.onx.domain.usecase.UserLoginUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class SplashViewModel extends ViewModel {

    private  final UserLoginUseCase userLoginUseCase;

    private MutableLiveData<Boolean> _isLogin = new MutableLiveData<>(false);
    public LiveData<Boolean> isLogin = _isLogin;

    private Disposable disposable;


    @Inject
    public SplashViewModel(UserLoginUseCase userLoginUseCase) {
        this.userLoginUseCase = userLoginUseCase;
        checkUserLogin();
    }


    public void checkUserLogin(){

            disposable = userLoginUseCase.isLogin().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            result -> {
                                 if (result!=null) {
                                     _isLogin.postValue(true);
                                 }
                            },
                            error -> {
                                Log.e("MyViewModel", "Error: " + error.getMessage());
                            }
                    );


    }




}
