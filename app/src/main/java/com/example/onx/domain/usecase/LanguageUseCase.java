package com.example.onx.domain.usecase;

import com.example.onx.domain.repo.Repository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;

public class LanguageUseCase {


    private final Repository repository;

    @Inject
    public LanguageUseCase(Repository repository) {
        this.repository = repository;
    }

    public void saveLang(String lang){
        repository.saveLanguag(lang);
    }

    public Flowable<String> getLanguage(){
        return repository.getLanguage();
    }





}
