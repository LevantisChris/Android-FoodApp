package com.example.foodapp.Activity.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.foodapp.Activity.Domain.FoodDomain;
import com.example.foodapp.Activity.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagmentCart {
    private Context context;
    private TinyDB tinyDB;


    public ManagmentCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(FoodDomain item) {
        ArrayList<FoodDomain> listFood = getListCart();
        boolean existAlready = false;
        int n = 0;
        for(int i = 0;i < listFood.size();i++) {
            if(listFood.get(i).getTitle().equals(item.getTitle())) {
                existAlready= true;
                n = i;
                break;
            }
        }

        if(existAlready) {
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listFood.add(item);
        }
        tinyDB.putListObject("CartList", listFood);
        Toast.makeText(context, "Added to your cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<FoodDomain> getListCart() {
        return tinyDB.getListObject("CartList");
    }

    public void plusNumberFood(ArrayList<FoodDomain> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart() + 1);
        tinyDB.putListObject("CartList", listfood);
        changeNumberItemsListener.changed();
    }

    public void minusNumberFood(ArrayList<FoodDomain> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {

        if(listfood.get(position).getNumberInCart() == 1) {
            listfood.remove(position);
        } else {
            listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart() - 1);
        }
        tinyDB.putListObject("CartList", listfood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<FoodDomain> listFood = getListCart();
        double fee = 0;
        for(int i = 0;i < listFood.size();i++) {
            fee = fee + (listFood.get(i).getFee() * listFood.get(i).getNumberInCart());
        }
        return fee;
    }
}
