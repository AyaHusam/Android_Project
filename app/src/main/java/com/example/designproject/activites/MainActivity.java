package com.example.designproject.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.designproject.Fragments.CategoryFragment;
import com.example.designproject.Fragments.HomeFragment;
import com.example.designproject.Fragments.MyAccountFragment;
import com.example.designproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView button_navigation_view;
    //RecyclerView recyclerViewCategoryList , recyclerView_popluar;
  //  RecyclerView.Adapter adapter , adapter_popluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton floatingActionButton = findViewById(R.id.btn_add_card_main_activity);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), CardListActivity.class));
            }
        });
        button_navigation_view = findViewById(R.id.bottom_navigation_view);
        button_navigation_view.setBackground(null);
        button_navigation_view.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
         getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new HomeFragment()).commit();
    }
     private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
         @Override
         public boolean onNavigationItemSelected(@NonNull MenuItem item) {

             Fragment selectedFragment = null;
             switch (item.getItemId()){
                 case R.id.btn_nav_home:
                     selectedFragment = new HomeFragment();
                     break;
                 case R.id.btn_nav_myaccount:
                     selectedFragment = new MyAccountFragment();
                     break;
                 case R.id.btn_nav_categories:
                     selectedFragment = new CategoryFragment();
                     break;

             }
             getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
             return true;
         }
     };


}