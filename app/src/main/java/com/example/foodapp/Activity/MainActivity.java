package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.foodapp.Activity.Adaptor.CategoryAdaptor;
import com.example.foodapp.Activity.Adaptor.PoplurarAdaptor;
import com.example.foodapp.Activity.Domain.CategoryDomain;
import com.example.foodapp.Activity.Domain.FoodDomain;
import com.example.foodapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout HomeBtn = findViewById(R.id.HomeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });
        HomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> arrayList = new ArrayList<>();
        arrayList.add(new CategoryDomain("Pizza", "cat_1"));
        arrayList.add(new CategoryDomain("Burger", "cat_2"));
        arrayList.add(new CategoryDomain("HotDog", "cat_3"));
        arrayList.add(new CategoryDomain("Drink", "cat_4"));
        arrayList.add(new CategoryDomain("Donut", "cat_5"));

        adapter = new CategoryAdaptor(arrayList);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni pizza", "pop_1", "slices pepperoni, mozzararela cheese, freash oregano, ground black pepper, pizza sause,0   slices pepperoni, mozzararela cheese, freash oregano, ground black pepper, pizza sause,     slices pepperoni, mozzararela cheese, freash oregano, ground black pepper, pizza sause,     slices pepperoni, mozzararela cheese, freash oregano, ground black pepper, pizza sause,     slices pepperoni, mozzararela cheese, freash oregano, ground black pepper, pizza sause, ", 9.76));
        foodList.add(new FoodDomain("Cheese Burger", "pop_2", "beef, Gouda Cheesse, Special Sause, Letture, tomato", 8.79));
        foodList.add(new FoodDomain("Vegetable Pizza", "pop_3", "olive oil, feta Kalamata, cherry tomato, fresh oregano", 10.99));

        adapter2 = new PoplurarAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}