package com.example.conversionapptestnow.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conversionapptestnow.R;
import com.example.conversionapptestnow.models.CurrencyModel;

public class CoinsAdapter extends ListAdapter<CurrencyModel, CoinsAdapter.CoinViewHolder> {

    private double selectedAmount;

    @SuppressLint("NotifyDataSetChanged")
    public void setSelectedAmount(double selectedAmount) {
        this.selectedAmount = selectedAmount;
        notifyDataSetChanged();
    }

    public CoinsAdapter(@NonNull ItemCallback<CurrencyModel> diffCallback, double selectedAmount) {
        super(diffCallback);
        this.selectedAmount = selectedAmount;
    }

    @NonNull
    @Override
    public CoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CoinViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_currency, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CoinViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class CoinViewHolder extends RecyclerView.ViewHolder {
        TextView tvUnit, tvAmount;

        public CoinViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUnit = itemView.findViewById(R.id.tvUnit);
            tvAmount = itemView.findViewById(R.id.tvAmount);
        }

        @SuppressLint("DefaultLocale")
        void bind(CurrencyModel model) {
            tvUnit.setText(model.getCurrencyName());
            tvAmount.setText(String.format("%.2f", model.getValue() * selectedAmount));
        }

    }

    public static class DiffCallback extends DiffUtil.ItemCallback<CurrencyModel> {

        @Override
        public boolean areItemsTheSame(@NonNull CurrencyModel oldModel, @NonNull CurrencyModel newModel) {
            return oldModel.getCurrencyName().equals(newModel.getCurrencyName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull CurrencyModel oldModel, @NonNull CurrencyModel newModel) {
            // No need to check the equality for all User fields ; just check the equality for fields that change the display of your item.
            // In your case, both impact the display.
            return oldModel.getCurrencyName().equals(newModel.getCurrencyName())
                    && (oldModel.getCurrencyName() == null) ? newModel.getCurrencyName() == null : oldModel.getCurrencyName().equals(newModel.getCurrencyName());
        }
    }
}


