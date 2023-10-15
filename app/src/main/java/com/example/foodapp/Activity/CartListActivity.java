package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.foodapp.Activity.Helper.ManagmentCart;
import com.example.foodapp.R;

public class CartListActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagmentCart managmentCart;
    TextView totalFeeText, taxText, deliveryText, totalText, emptyText;
    private double tex;
    private ScrollView scrollView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        managmentCart = new ManagmentCart(this);

        initView();
    }

    private void initView() {
        recyclerViewList = findViewById(R.id.recyclerView);
        totalFeeText = findViewById(R.id.totalFeeText);
        taxText = findViewById(R.id.taxText);
        deliveryText = findViewById(R.id.deliveryText);
        totalText = findViewById(R.id.totalText);
        emptyText = findViewById(R.id.emptyText);
        scrollView = findViewById(R.id.ScrollView);
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
    }
}