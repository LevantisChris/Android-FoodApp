package com.example.foodapp.Activity.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.foodapp.Activity.Domain.FoodDomain;

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
        tinyDB.putListObject("CardList", listFood);
        Toast.makeText(context, "Added to your cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<FoodDomain> getListCart() {
        return tinyDB.getListObject("CartList");
    }
}
