package com.example.designproject.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.designproject.Domain.DomainCategory;
import com.example.designproject.Domain.DomainFashion;
import com.example.designproject.Helper.Management;
import com.example.designproject.R;
import com.example.designproject.adapter.CategoryAdapter;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCardBtn;
    private TextView title_txt, fee_Text, description_txt, number_order_txt;
    private ImageView plus_btn, minus_btn, pic_order;
    private int number_order = 1;
    private DomainFashion Object;
    private Management management;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        management = new Management(this);
        initView();
        getBundle();
    }

    private void getBundle() {
        Object = (DomainFashion) getIntent().getSerializableExtra("Object_data_from_popular");
        int drawableResouseId = this.getResources().getIdentifier(Object.getPhoto(), "drawable", this.getPackageName());
        Glide.with(this).load(drawableResouseId).into(pic_order);
        title_txt.setText(Object.getTitle());
        fee_Text.setText( "$"+Object.getFee());
        description_txt.setText(Object.getDescription());
        number_order_txt.setText(String.valueOf(number_order));
        plus_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               number_order  = number_order+1;
               number_order_txt.setText(String.valueOf(number_order));
           }
       });
       minus_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if( number_order > 1 ){
                   number_order= number_order - 1;
               }
               number_order_txt.setText(String.valueOf(number_order));
           }
       });
       addToCardBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            Object.setNumberInCard(number_order);
            management.insertOrder(Object);
           }
       });
    }
    private void initView() {
        addToCardBtn = findViewById(R.id.addToCardBtn);
        title_txt = findViewById(R.id.Title_Text);
        fee_Text = findViewById(R.id.priceText);
        description_txt = findViewById(R.id.descriptionTxt);
        number_order_txt = findViewById(R.id.Number_order_txt);
        plus_btn = findViewById(R.id.plus_btn);
        minus_btn = findViewById(R.id.minu_Btn);
        pic_order = findViewById(R.id.photo_order);
    }
}