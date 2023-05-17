package com.example.onx.app.ui.home;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.onx.domain.models.DeliveryBill;
import com.example.onx.domain.usecase.GetDeliveryBillsItemUseCase;
import com.example.onx.domain.usecase.UserLoginUseCase;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    private final GetDeliveryBillsItemUseCase getDeliveryBillsItemUseCase;
    private  final UserLoginUseCase userLoginUseCase;

    public MutableLiveData<List<DeliveryBill>> _billsItem = new MutableLiveData<>() ;
    public LiveData<List<DeliveryBill>> billsItem = _billsItem;



    public ObservableField<String> userName = new ObservableField<>("");

    private Disposable disposable;




    @Inject
    public HomeViewModel(GetDeliveryBillsItemUseCase getDeliveryBillsItemUseCase, UserLoginUseCase userLoginUseCase) {
        this.getDeliveryBillsItemUseCase = getDeliveryBillsItemUseCase;
        this.userLoginUseCase = userLoginUseCase;
        getBillsItems(P_Process_Flag.NEW);
        useData();

    }


    public  void getBillsItems(P_Process_Flag pProcessedFlag){

        switch (pProcessedFlag){
            case NEW :
                getBillsItem("0");
                break;

            case OTHER:
                getBillsItem("1");
                break;

        }

    }

    private void getBillsItem(String pProcessFlag) {
        disposable = getDeliveryBillsItemUseCase.getDeliveryBillsItems("1", pProcessFlag).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> {
                            _billsItem.postValue(result.getData().getDeliveryBills());
                        },
                        error -> {
                            Log.e("MyViewModel", "Error: " + error.getMessage());
                        }
                );
    }

    private void useData() {

            disposable = userLoginUseCase.isLogin().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            result -> {
                                if (result!=null) {
                                   userName.set(result);
                                }
                            },
                            error -> {
                                Log.e("MyViewModel", "Error: " + error.getMessage());
                            }
                    );




    }


    enum  P_Process_Flag{
        NEW,
        OTHER

    }
}
