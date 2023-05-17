package com.example.onx.app.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onx.R;
import com.example.onx.app.ui.login.LoginViewModel;
import com.example.onx.databinding.FragmentHomeBinding;
import com.example.onx.domain.models.DeliveryBill;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

     private FragmentHomeBinding binding;
     private HomeViewModel homeViewModel;
     private BillsItemAdapter billsItemAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        binding.setHomeViewModel(homeViewModel);
        binding.setLifecycleOwner(this);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();
        setupClicked();
    }

    private void setupClicked() {

        binding.btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeViewModel.getBillsItems(HomeViewModel.P_Process_Flag.NEW);
                binding.btnNew.setTextColor(getResources().getColor(R.color.white));
                binding.btnNew.setBackground(getResources().getDrawable(R.drawable.tab_bg_selected));
                binding.btnOther.setTextColor(getResources().getColor(R.color.text_color));
                binding.btnOther.setBackground(getResources().getDrawable(R.drawable.tab_bg_unselected));
            }
        });

        binding.btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnNew.setTextColor(getResources().getColor(R.color.text_color));
                binding.btnNew.setBackground(getResources().getDrawable(R.drawable.tab_bg_unselected));
                binding.btnOther.setTextColor(getResources().getColor(R.color.white));
                binding.btnOther.setBackground(getResources().getDrawable(R.drawable.tab_bg_selected));
                homeViewModel.getBillsItems(HomeViewModel.P_Process_Flag.OTHER);
            }
        });
    }

    private void initRecyclerView() {

         billsItemAdapter=  new BillsItemAdapter();
         binding.recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        homeViewModel.billsItem.observe(getViewLifecycleOwner(),list-> {
            if(list==null){

                binding.emptyList.setVisibility(View.VISIBLE);
                binding.emptyList2.setVisibility(View.VISIBLE);
                binding.textEmpty.setVisibility(View.VISIBLE);
                binding.textEmpty2.setVisibility(View.VISIBLE);
            }else {
                binding.emptyList.setVisibility(View.GONE);
                binding.emptyList2.setVisibility(View.GONE);
                binding.textEmpty.setVisibility(View.GONE);
                binding.textEmpty2.setVisibility(View.GONE);

            }
                billsItemAdapter.submitList(list);
                binding.recyclerView.setAdapter(billsItemAdapter);



        });

    }
}