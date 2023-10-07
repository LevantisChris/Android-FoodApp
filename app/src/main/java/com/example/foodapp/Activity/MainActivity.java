package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.foodapp.Activity.Domain.CategoryDomain;
import com.example.foodapp.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
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
    }
}