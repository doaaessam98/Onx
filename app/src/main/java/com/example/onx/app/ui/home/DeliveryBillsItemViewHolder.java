package com.example.onx.app.ui.home;


import android.content.Context;
import android.graphics.Color;

import androidx.recyclerview.widget.RecyclerView;

import com.example.onx.R;
import com.example.onx.databinding.ItemDeliveryBillBinding;
import com.example.onx.domain.models.BillItem;
import com.example.onx.domain.models.DeliveryBill;

public class DeliveryBillsItemViewHolder extends RecyclerView.ViewHolder {
        private ItemDeliveryBillBinding binding;

        public DeliveryBillsItemViewHolder(ItemDeliveryBillBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(DeliveryBillsItemViewHolder holder, DeliveryBill deliveryBill) {
            BillItem item =new BillItem();
            if (deliveryBill.getBILLTYPE().equalsIgnoreCase("1")) {
                item.setItemStatus(deliveryBill.getDLVRYSTATUSFLG());
                switch (item.getItemStatus()){
                    case "Delivered":
                        break;
                    case "Partial Return":
                        binding.detailsText.setBackgroundColor(holder.itemView.getResources().getColor(R.color.gray));
                        break;
                    case "Full Returned":
                        binding.detailsText.setBackgroundColor(holder.itemView.getResources().getColor(R.color.red));
                        break;
                };
            }else {
                item.setItemStatus(String.valueOf(R.string.active));
            }
            item.setItemDate(deliveryBill.getBILLDATE());
            item.setItemPrice(deliveryBill.getBILLAMT());
            item.setItemNumber(deliveryBill.getBILLSRL());

            binding.setBillItem(item);
            binding.executePendingBindings();
        }
    }


