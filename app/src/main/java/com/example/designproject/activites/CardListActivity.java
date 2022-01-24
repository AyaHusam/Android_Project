package com.example.designproject.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.designproject.Helper.Management;
import com.example.designproject.Interface.ChangeNumberItemListener;
import com.example.designproject.R;
import com.example.designproject.adapter.CardListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CardListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private  RecyclerView recyclerViewList;
    private Management management;
    private TextView totalFeetxt , taxTxt, deliveryTxt, totalTxt, emptyTxt;
    private  double tax;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);
        management = new Management(this);
        initVeiw();
        initList();
        calculateCard();
        
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this ,LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CardListAdapter(management.getListCard(), this, new ChangeNumberItemListener() {
            @Override
            public void changed() {
                 calculateCard();
            }
        });
         recyclerViewList.setAdapter(adapter);
         if(management.getListCard().isEmpty()){
             emptyTxt.setVisibility(View.VISIBLE);
             scrollView.setVisibility(View.GONE);

         }
         else{
             emptyTxt.setVisibility(View.GONE);
             scrollView.setVisibility(View.VISIBLE);
         }


    }
    private  void calculateCard(){
        double percentTax=0.02;
        double delivery=10;
        tax = Math.round((management.getTotalFee()*percentTax)*100.0)/100.0;
        double total = Math.round((management.getTotalFee()+tax+delivery)*100.0)/100.0;
        double itemTotal =Math.round(management.getTotalFee()*100.0)/100.0;
        totalFeetxt.setText("$"+ itemTotal);
        taxTxt.setText("$"+tax);
        deliveryTxt.setText("$"+delivery);
        totalTxt.setText("$" + total);

    }
    private void initVeiw() {
        recyclerViewList = findViewById(R.id.Recycler_Card);
        taxTxt = findViewById(R.id.Tax_total_txt);
        deliveryTxt = findViewById(R.id.Tax_deliverServier_txt);
        totalFeetxt = findViewById(R.id.Tax_itemsTotal_txt);
        totalTxt = findViewById(R.id.Tax_total_txt);
        emptyTxt = findViewById(R.id.emptytxt);
        scrollView = findViewById(R.id.scrollviewCard);

    }
}