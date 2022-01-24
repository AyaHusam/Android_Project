package com.example.designproject.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designproject.Domain.DomainCategory;
import com.example.designproject.Domain.DomainFashion;
import com.example.designproject.Domain.ParentRecylcerView;
import com.example.designproject.R;
import com.example.designproject.RecyclerViewInterface;
import com.example.designproject.adapter.CategoryAdapter;
import com.example.designproject.adapter.ParantRecylerAdapter;
import com.example.designproject.adapter.PopularAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

   RecyclerView recyclerViewCategoryList , recyclerView_popluar;
   RecyclerView.Adapter adapter , adapter_popluar;
   ArrayList<ParentRecylcerView> parentRecylcerViewArrayList;
   ArrayList<DomainCategory> domainCategoryArrayList;
   ArrayList<DomainCategory> SportWearList;
   ArrayList<DomainCategory> TunicList;
   ArrayList<DomainCategory> DresssesList;
   ArrayList<DomainCategory> PantsList;
    ArrayList<DomainCategory> Outerwear;

    ParantRecylerAdapter parantRecylerAdapter;
    FloatingActionButton floatingActionButton;
    @Nullable
    @Override
    public View  onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View  view =inflater.inflate(R.layout.homefragments, container, false);
        // This method to popluar
        //   recyclerViewPopluar();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false);
        recyclerView_popluar = view.findViewById(R.id.recyclerView12);
        recyclerView_popluar.setLayoutManager(linearLayoutManager);
        ArrayList<DomainFashion> domainFashionArrayList = new ArrayList<>();
        domainFashionArrayList.add(new DomainFashion("Dresses" , "image16", "The Dressaes" , 10));
        domainFashionArrayList.add(new DomainFashion("Sports wear" , "image17", "The Dressaes" , 20));
        domainFashionArrayList.add(new DomainFashion("Plus Size" , "image13", "The Dressaes" , 30));
        domainFashionArrayList.add(new DomainFashion("Tracksuits" , "img", "The Dressaes" , 25));
        adapter_popluar = new PopularAdapter(domainFashionArrayList);
        recyclerView_popluar.setAdapter(adapter_popluar);

     //   NESTED CYCLECVIEW FOR CATRGORY RECYCLERVIEW
        recyclerViewCategoryList = view.findViewById(R.id.recyclerView2_categories);
         domainCategoryArrayList = new ArrayList<>();
         SportWearList = new ArrayList<>();
         TunicList = new ArrayList<>();
         DresssesList = new ArrayList<>();
         PantsList = new ArrayList<>();
        Outerwear = new ArrayList<>();
         parentRecylcerViewArrayList = new ArrayList<>();
        TunicList.add(new DomainCategory("Sweat-shirt-Orange" , R.drawable.image25 , "$ 17.49"));

        TunicList.add(new DomainCategory("Sweat-shirt-Ecru" , R.drawable.image23 , "$ 17.99"));
        TunicList.add(new DomainCategory("Tracksuit- Mint", R.drawable.image24 ,"$ 19.59" ));
        TunicList.add(new DomainCategory("Traxksuit Set-Gray" , R.drawable.image22 , "$ 22.99"));
        TunicList.add(new DomainCategory("Tracksuit- Black" , R.drawable.image31, "$ 23.99"));
        TunicList.add(new DomainCategory("TrackSuit- pink" , R.drawable.image29, "$ 17.55"));
        Outerwear.add(new DomainCategory("Caramel-navy Blue" , R.drawable.image56 , "$ 22.99"));
        Outerwear.add(new DomainCategory("Gray-Plaid-Cotton" , R.drawable.image54 , "$ 18.19"));
        Outerwear.add(new DomainCategory( "Coat-Black" , R.drawable.image33 , "$ 20.29"));
        Outerwear.add(new DomainCategory("Gray_navy Blue" , R.drawable.image55 , "$ 23.00"));
        Outerwear.add(new DomainCategory("Coat- navy Black" , R.drawable.image34 , "20.99"));


        parentRecylcerViewArrayList.add(new ParentRecylcerView("Sweatshirts & Tracksuits" , TunicList));
        parentRecylcerViewArrayList.add(new ParentRecylcerView("Outerwear" , Outerwear));
        parantRecylerAdapter = new ParantRecylerAdapter(parentRecylcerViewArrayList, getContext());
         recyclerViewCategoryList.setLayoutManager(new LinearLayoutManager(getContext()));
         recyclerViewCategoryList.setAdapter(parantRecylerAdapter);
         //parantRecylerAdapter.notifyDataSetChanged();

        return view ;

    }
}
























   /* private void bottomNavigation() {
        FloatingActionButton floatingActionButton= findViewById(R.id.btn_add_card_main_activity);
        // LinearLayout  homeBtn = findViewById(R.id.btn_nav_home);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CardListActivity.class));
            }
        });
    }

    private void recyclerViewPopluar() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( this , LinearLayoutManager.HORIZONTAL , false);
        recyclerView_popluar = findViewById(R.id.recyclerView12);
        recyclerView_popluar.setLayoutManager(linearLayoutManager);
        ArrayList<DomainFashion> domainFashionArrayList = new ArrayList<>();

        domainFashionArrayList.add(new DomainFashion("Dresses" , "image16", "The Dressaes" , 10));
        domainFashionArrayList.add(new DomainFashion("Sports wear" , "image17", "The Dressaes" , 20));
        domainFashionArrayList.add(new DomainFashion("Plus Size" , "image13", "The Dressaes" , 30));
        domainFashionArrayList.add(new DomainFashion("Tracksuits" , "img", "The Dressaes" , 25));
        adapter_popluar = new PopularAdapter(domainFashionArrayList);
        recyclerView_popluar.setAdapter(adapter_popluar);

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager12 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL , false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView2_categories);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager12);
        ArrayList<DomainCategory> categoryArrayList = new ArrayList<>();
        categoryArrayList.add(new DomainCategory("Sports wear", "image12"));
        categoryArrayList.add(new DomainCategory("Tunic&Tops", "image17"));
        categoryArrayList.add(new DomainCategory("Dresses","image16"));
        categoryArrayList.add(new DomainCategory("Pants&Skirts", "image14"));
        categoryArrayList.add(new DomainCategory("Plus Size", "image13"));
        adapter = new CategoryAdapter(categoryArrayList);
        recyclerViewCategoryList.setAdapter(adapter);

    }

*/