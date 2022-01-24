package com.example.designproject.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.designproject.R;

public class ShowDetailCategory extends AppCompatActivity {
    private int number_order = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail_category);
        String name = getIntent().getStringExtra("title");
        String price = getIntent().getStringExtra("photoCategory");
        int image = getIntent().getIntExtra("priceCategory" , 0);


        ImageView imageaa = findViewById(R.id.photo_category_showDetail);
        TextView price_tv = findViewById(R.id.priceText_category_showDetail);
        TextView title = findViewById(R.id.Title_Category_showDetail);
        TextView number_order_txt = findViewById(R.id.Number_order_txt_category);
        ImageView plus_btn_category = findViewById(R.id.plus_btn_category);
        ImageView minus_btn_category = findViewById(R.id.minu_Btn_category);


        imageaa.setImageResource(image);
        price_tv.setText(price);
        title.setText(name);
        plus_btn_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number_order  = number_order+1;
                number_order_txt.setText(String.valueOf(number_order));
            }
        });
        minus_btn_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( number_order > 1 ){
                    number_order= number_order - 1;
                }
                number_order_txt.setText(String.valueOf(number_order));
            }
        });

}}