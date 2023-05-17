package com.example.onx.app.ui.login;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.onx.domain.usecase.LanguageUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class LanguageViewModel extends ViewModel {

    private  final LanguageUseCase languageUseCase;

     @Inject
    public LanguageViewModel(LanguageUseCase languageUseCase) {
        this.languageUseCase = languageUseCase;
    }



    public  void saveLang(String lang){
          languageUseCase.saveLang(lang);
    }
}
