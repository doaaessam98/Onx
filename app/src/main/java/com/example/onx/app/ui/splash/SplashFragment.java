package com.example.onx.app.ui.splash;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onx.R;
import com.example.onx.app.ui.home.HomeViewModel;
import com.example.onx.databinding.FragmentHomeBinding;
import com.example.onx.databinding.FragmentSplashBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SplashFragment extends Fragment {

     private FragmentSplashBinding binding;
    private SplashViewModel splashViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashViewModel = new ViewModelProvider(this).get(SplashViewModel.class);
        binding = FragmentSplashBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splashViewModel.isLogin.observe(getViewLifecycleOwner(), isLogin->{
                    if (isLogin){
                        Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_homeFragment);

                    }else {
                        Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_loginFragment);

                    }
                });
            }
        }, 3000);


    }
}