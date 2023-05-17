package com.example.onx.app.ui.login;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onx.R;
import com.example.onx.app.ui.login.LoginViewModel;
import com.example.onx.databinding.FragmentLoginBinding;
import com.example.onx.domain.models.Data;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint

public class LoginFragment extends Fragment  {

    private  LoginViewModel loginViewModel;
    public FragmentLoginBinding binding;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        binding.setLoginViewModel(loginViewModel);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loginViewModel.isLogin.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLogin) {
                if (isLogin) {
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment);
                }
            }
        });

        binding.loginLan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageDialogFragment languageDialogFragment = new LanguageDialogFragment();
                languageDialogFragment.show(getFragmentManager(),
                        "langDialog");
            }
        });
    }


}