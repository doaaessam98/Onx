package com.example.onx.app.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.onx.databinding.ItemDeliveryBillBinding;
import com.example.onx.domain.models.DeliveryBill;
import com.example.onx.domain.models.DeliveryBillsItem;

public class BillsItemAdapter extends ListAdapter<DeliveryBill,DeliveryBillsItemViewHolder> {

    public BillsItemAdapter(){
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public DeliveryBillsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        ItemDeliveryBillBinding binding = ItemDeliveryBillBinding.inflate(inflater, parent, false);

        return new DeliveryBillsItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryBillsItemViewHolder holder, int position) {
        holder.bind(holder,getItem(position));


    }

    public static final DiffUtil.ItemCallback<DeliveryBill> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<DeliveryBill>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull DeliveryBill  oldItem, @NonNull DeliveryBill newItem) {
                    return oldItem.getBILLNO()== newItem.getBILLNO();
                }
                @Override
                public boolean areContentsTheSame(
                        @NonNull DeliveryBill oldItem, @NonNull DeliveryBill newItem) {
                    return oldItem.equals(newItem);
                }
            };
}















