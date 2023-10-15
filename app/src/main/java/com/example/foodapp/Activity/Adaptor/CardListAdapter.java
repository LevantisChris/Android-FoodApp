package com.example.foodapp.Activity.Adaptor;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Activity.Domain.FoodDomain;
import com.example.foodapp.Activity.Helper.ManagmentCart;
import com.example.foodapp.Activity.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class CardListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {

    private ArrayList<FoodDomain> foodDomainArrayList;
    private ManagmentCart managmentCart;
    private ChangeNumberItemsListener changeNumberItemsListener;

    public CardListAdapter(ArrayList<FoodDomain> foodDomainArrayList, ManagmentCart managmentCart, ChangeNumberItemsListener changeNumberItemsListener) {
        this.foodDomainArrayList = foodDomainArrayList;
        this.managmentCart = managmentCart;
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @Override
    public CartListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CartListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return foodDomainArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, feeEachItem;
        ImageView pic, plusItem, minusItem;
        TextView totalEachItem, num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id);
        }
    }
}
