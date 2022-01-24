package com.example.designproject.Fragments;

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
import com.example.designproject.Domain.ParentRecylcerView;
import com.example.designproject.R;
import com.example.designproject.RecyclerViewInterface;
import com.example.designproject.activites.ShowDetailCategory;
import com.example.designproject.adapter.ParantRecylerAdapter;

import java.util.ArrayList;

public class CategoryFragment  extends Fragment  implements RecyclerViewInterface {
    RecyclerView rv_fragemnt_category;
    ArrayList<ParentRecylcerView> parentRecylcerViewArrayList;
    ArrayList<DomainCategory> domainCategoryArrayList;
    ArrayList<DomainCategory> SportWearList;
    ArrayList<DomainCategory> TunicList;
    ArrayList<DomainCategory> DresssesList;
    ArrayList<DomainCategory> PantsList;
    ArrayList<DomainCategory> Outerwear;
    ParantRecylerAdapter parantRecylerAdapter;
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
      View view = inflater.inflate(R.layout.category_fragment, container, false);
        rv_fragemnt_category = view.findViewById(R.id.rv_category_fragment);
        domainCategoryArrayList = new ArrayList<>();
        SportWearList = new ArrayList<>();
        TunicList = new ArrayList<>();
        DresssesList = new ArrayList<>();
        PantsList = new ArrayList<>();
        Outerwear = new ArrayList<>();
        parentRecylcerViewArrayList = new ArrayList<>();

        PantsList.add(new DomainCategory("pant-Black" , R.drawable.image11 , "$ 17.09"));
        PantsList.add(new DomainCategory("Skirt-Black" , R.drawable.image81 , "$ 11.00"));
        PantsList.add(new DomainCategory("Skirt-Gray" , R.drawable.image61 , "$ 9.99"));
        PantsList.add(new DomainCategory("Skirt", R.drawable.image21, "$ 12.79"));
        PantsList.add(new DomainCategory("Skirt- NavyBlue", R.drawable.image441 , "30.39"));
        PantsList.add(new DomainCategory("Skirt- Green Almond", R.drawable.image51 , "$ 8.99"));
        PantsList.add(new DomainCategory("Skirt- Black" , R.drawable.image71 , "$ 12.00"));
        ///////////
        TunicList.add(new DomainCategory("Sweat-shirt-Ecru" , R.drawable.image23 , "$ 17.99"));
        TunicList.add(new DomainCategory("Sweat-shirt-Ecru-Orange" , R.drawable.image25 , "$ 17.49"));
        TunicList.add(new DomainCategory("Tracksuit- Mint", R.drawable.image24 ,"$ 19.59" ));
        TunicList.add(new DomainCategory("Traxksuit Set-Gray" , R.drawable.image22 , "$ 22.99"));
        TunicList.add(new DomainCategory("Tracksuit- Black" , R.drawable.image31, "$ 23.99"));
        TunicList.add(new DomainCategory("TrackSuit- pink" , R.drawable.image29, "$ 17.55"));
        /////////////***
        Outerwear.add(new DomainCategory("Caramel-navy Blue" , R.drawable.image56 , "$ 22.99"));
        Outerwear.add(new DomainCategory("Gray-Plaid-Cotton" , R.drawable.image54 , "$ 18.19"));
        Outerwear.add(new DomainCategory( "Coat-Black" , R.drawable.image33 , "$ 20.29"));
        Outerwear.add(new DomainCategory("Gray_navy Blue" , R.drawable.image55 , "$ 23.00"));
        Outerwear.add(new DomainCategory("Coat- navy Black" , R.drawable.image34 , "20.99"));
        Outerwear.add(new DomainCategory("Abaya-Navy Blue" , R.drawable.image42 , "$ 51.09"));

        Outerwear.add(new DomainCategory("Abaya-Black" , R.drawable.image41 , "$19.99"));


        //////////////////***
        DresssesList.add(new DomainCategory("Dress-plum" , R.drawable.image53 , " $ 25.19"));
        DresssesList.add(new DomainCategory("Dress-Powder" , R.drawable.image58, "$ 19.99"));
        DresssesList.add(new DomainCategory("Dress-Gray-Pink" , R.drawable.image57 , "$ 19.99"));
        DresssesList.add(new DomainCategory("Dress-white-Green" , R.drawable.image60 , "$20.79"));
        SportWearList.add(new DomainCategory("Sport Wear", R.drawable.image2, "$ 20.99"));
        SportWearList.add(new DomainCategory("Sport wear" , R.drawable.image26, "$ 15.00")) ;
        SportWearList.add(new DomainCategory("t-shirt" , R.drawable.image28, "$ 20.22"));
        SportWearList.add(new DomainCategory("Black" , R.drawable.image27, "$20.99"));

        parentRecylcerViewArrayList.add(new ParentRecylcerView("Sweatshirts & Tracksuits" , TunicList));
        parentRecylcerViewArrayList.add(new ParentRecylcerView("Pants & Skirts" , PantsList));
        parentRecylcerViewArrayList.add(new ParentRecylcerView("Outerwear" , Outerwear));
        parentRecylcerViewArrayList.add(new ParentRecylcerView("Dresses" , DresssesList));
        parentRecylcerViewArrayList.add(new ParentRecylcerView("SportWear" , SportWearList));
        parantRecylerAdapter = new ParantRecylerAdapter(parentRecylcerViewArrayList, getContext());
        rv_fragemnt_category.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_fragemnt_category.setAdapter(parantRecylerAdapter);
      return  view;


    }
    @Override
    public void onItemClick(int postion) {
        Intent intent = new Intent(getContext() , ShowDetailCategory.class);
        intent.putExtra("title" , domainCategoryArrayList.get(postion).getTitle());
        intent.putExtra("photoCategory", domainCategoryArrayList.get(postion).getPhoto());
        intent.putExtra("priceCategory" , domainCategoryArrayList.get(postion).getPrice());
        startActivity(intent);

    }


}
