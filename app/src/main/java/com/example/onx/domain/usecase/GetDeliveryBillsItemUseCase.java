package com.example.onx.domain.usecase;

import com.example.onx.domain.models.DeliveryBillsItem;
import com.example.onx.domain.repo.Repository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class GetDeliveryBillsItemUseCase {

    private final Repository repository;

    @Inject
    public GetDeliveryBillsItemUseCase(Repository repository) {
        this.repository = repository;
    }

    public Single<DeliveryBillsItem> getDeliveryBillsItems(String lang , String processed_flag){
        return repository.getDeliveryBillsItems(lang,processed_flag);
    }
}
