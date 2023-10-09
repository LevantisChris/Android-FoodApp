package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodapp.Activity.Domain.FoodDomain;
import com.example.foodapp.Activity.Helper.ManagmentCart;
import com.example.foodapp.R;

public class ShowDetailActivity extends AppCompatActivity {

    private TextView addToCartBtn;
    private TextView titleText, feeText, descriptionText, numberOrderText;
    private ImageView plusBtn, minusBtn, picFood;
    private FoodDomain object;
    private int numberOrder_counter = 1;
    private ManagmentCart managmentCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managmentCart = new ManagmentCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {
        object = (FoodDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);
        titleText.setText(object.getTitle());
        feeText.setText("€" + object.getFee());
        descriptionText.setText(object.getDescription());
        numberOrderText.setText(String.valueOf(numberOrder_counter));

        plusBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                numberOrder_counter++;
                numberOrderText.setText(String.valueOf(numberOrder_counter));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(numberOrder_counter > 1) {
                    numberOrder_counter--;
                }
                numberOrderText.setText(String.valueOf(numberOrder_counter));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOrder_counter);
                managmentCart.insertFood(object);
            }
        });
    }

    private void initView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleText = findViewById(R.id.titleText);
        feeText = findViewById(R.id.priceText);
        descriptionText = findViewById(R.id.descriptionText);
        numberOrderText = findViewById(R.id.numberOrderText);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        picFood = findViewById(R.id.picFood);
    }
}