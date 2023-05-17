package com.example.onx.app.ui.login;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.onx.R;
import com.example.onx.databinding.FragmentLanguageDialogBinding;

import java.util.Locale;


public class LanguageDialogFragment extends DialogFragment {

     FragmentLanguageDialogBinding binding;
     String lang  = "1" ;
      LanguageViewModel languageViewModel;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        languageViewModel = new ViewModelProvider(requireActivity()).get(LanguageViewModel.class);

        binding = FragmentLanguageDialogBinding.inflate(getLayoutInflater());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding.btnArabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lang = "0";
                binding.btnArabic.setBackgroundColor(getResources().getColor(R.color.light_green));
                binding.btnEnglish.setBackgroundColor(getResources().getColor(R.color.white));

            }
        });

        binding.btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lang = "1";
                binding.btnEnglish.setBackgroundColor(getResources().getColor(R.color.light_green));
                binding.btnArabic.setBackgroundColor(getResources().getColor(R.color.white));


            }
        });
        binding.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                languageViewModel.saveLang(lang);
                changeLanguage(lang);
                dismiss();
                requireActivity().recreate();
            }
        });

        return binding.getRoot();
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

        }}

}




