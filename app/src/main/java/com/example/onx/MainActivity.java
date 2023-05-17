package com.example.onx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.example.onx.app.ui.login.LanguageViewModel;
import com.example.onx.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;


import java.util.Locale;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavController navController;

    LanguageViewModel languageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        languageViewModel = new ViewModelProvider(this).get(LanguageViewModel.class);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        handelLang();

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

    }

    private void handelLang() {
        languageViewModel.language.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                changeLanguage(s);
            }
        });
    }

    private void changeLanguage(String language) {
         String lang = language.equals("1")?"en":"ar";
        Locale selectedLanguage = new Locale(lang);
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        if (!selectedLanguage.equals(configuration.locale)) {
            Configuration newConfig = new Configuration(configuration);
            newConfig.setLocale(selectedLanguage);
            Locale.setDefault(selectedLanguage);
            resources.updateConfiguration(newConfig, null);

    }
}}