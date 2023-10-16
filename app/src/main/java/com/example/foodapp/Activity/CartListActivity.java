package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.foodapp.Activity.Adaptor.CartListAdapter;
import com.example.foodapp.Activity.Helper.ManagmentCart;
import com.example.foodapp.Activity.Interface.ChangeNumberItemsListener;
import com.example.foodapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CartListActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagmentCart managmentCart;
    TextView totalFeeText, taxText, deliveryText, totalText, emptyText;
    private double tax;
    private ScrollView scrollView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        managmentCart = new ManagmentCart(this);

        initView();
        initList();
        calculateCart();
        bottomNavigation();
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout HomeBtn = findViewById(R.id.HomeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this, CartListActivity.class));
            }
        });
        HomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this, MainActivity.class));
            }
        });
    }

    private void initView() {
        recyclerViewList = findViewById(R.id.recyclerView);
        totalFeeText = findViewById(R.id.totalFeeText);
        taxText = findViewById(R.id.taxText);
        deliveryText = findViewById(R.id.deliveryText);
        totalText = findViewById(R.id.totalText);
        emptyText = findViewById(R.id.emptyText);
        scrollView = findViewById(R.id.ScrollView);
        recyclerViewList = findViewById(R.id.cartView);
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter( managmentCart.getListCart(), this,  new ChangeNumberItemsListener() {
            @Override
            public void changed() {

            }
        });

        recyclerViewList.setAdapter(adapter);
        if(managmentCart.getListCart().isEmpty()) {
            emptyText.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyText.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCart() {
        double percentTax = 0.24;
        double delivery = 10;

        tax = Math.round((managmentCart.getTotalFee() * percentTax) * 100) / 100;
        double total = Math.round((managmentCart.getTotalFee() + tax + delivery)* 100) * 100;
        double itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100;

        totalFeeText.setText("€" + itemTotal);
        taxText.setText("€" + tax);
        deliveryText.setText("€" + delivery);
        totalText.setText("€" + total);
    }
}