package com.example.onx.app.ui.login;

import static android.content.ContentValues.TAG;

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
public class LoginViewModel  extends ViewModel {

    private  final UserLoginUseCase userLoginUseCase;

    public ObservableField<String> userPassword = new ObservableField<>("");
    public ObservableField<String> userId = new ObservableField<>("");
    public ObservableField<Boolean> progress_bar = new ObservableField<>(false);
    public ObservableField<Boolean> show_error = new ObservableField<>(false);
    public MutableLiveData<String> errorMessage = new MutableLiveData<>("") ;
    private MutableLiveData<Boolean> _isLogin = new MutableLiveData<>(false);
    public LiveData<Boolean> isLogin = _isLogin;
    public MutableLiveData<String> lang= new MutableLiveData<>("1") ;

    private Disposable disposable;


    @Inject
    public LoginViewModel(UserLoginUseCase userLoginUseCase) {
        this.userLoginUseCase = userLoginUseCase;
    }


     public void checkUserLogin(){
         Log.e(TAG, "checkUserLogin: "+lang.getValue());
            String id = userId.get();
            String password = userPassword.get();
           if (validateData(id,password)) {
               progress_bar.set(true);
               disposable = userLoginUseCase.CheckDeliveryLogin(lang.getValue(), id, password).subscribeOn(Schedulers.io())
                       .observeOn(AndroidSchedulers.mainThread())
                       .subscribe(
                               result -> {
                                   progress_bar.set(false);
                                   Log.e("MyViewModel", "Error: " + result.getResult().getErrMsg());
                                   if (result.getResult().getErrMsg().equals("Successful")){
                                        userLoginUseCase.saveUser(result.getData());
                                       _isLogin.postValue(true);
                                     }
                                   else {
                                       show_error.set(true);
                                       errorMessage.postValue(result.getResult().getErrMsg());
                                   }

                               },
                               error -> {
                                   progress_bar.set(false);
                                   show_error.set(true);
                                   errorMessage.postValue(error.getMessage());
                                   Log.e("MyViewModel", "Error: " + error.getMessage());
                               }
                       );
           }else {

           }

     }

     private Boolean validateData(String userId,String password){
         return !userId.isEmpty() && !password.isEmpty();
     }
}
