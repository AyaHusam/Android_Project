package com.example.designproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.designproject.Domain.DomainFashion;
import com.example.designproject.Helper.Management;
import com.example.designproject.Interface.ChangeNumberItemListener;
import com.example.designproject.R;
import com.example.designproject.activites.ShowDetailActivity;

import java.util.ArrayList;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.PopularHodler> {
     ArrayList<DomainFashion> domainPopular_data;
     private  Management management;
     ChangeNumberItemListener changeNumberItemListener;
    public CardListAdapter(ArrayList<DomainFashion> domainPopular_data , Context context , ChangeNumberItemListener changeNumberItemListener) {
        this.domainPopular_data = domainPopular_data;
        management = new Management(context);
        this.changeNumberItemListener = changeNumberItemListener;

    }

    @NonNull
    @Override
    public PopularHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cardlist,parent,false);
        return new PopularHodler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  PopularHodler holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(domainPopular_data.get(position).getTitle());
        holder.feeEachItem.setText(String.valueOf(domainPopular_data.get(position).getFee()));
        holder.totalEachItem.setText(String.valueOf(Math.round((domainPopular_data.get(position).getNumberInCard() *domainPopular_data.get(position).getFee())*100.0)/100.0));
        holder.num.setText(String.valueOf(domainPopular_data.get(position).getNumberInCard()));
        int drawableResourceId= holder.itemView.getContext().getResources().getIdentifier(domainPopular_data.get(position).getPhoto(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.photo);
        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                management.plusNumberOrder(domainPopular_data, position, new ChangeNumberItemListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemListener.changed();
                    }
                });

            }
        });
        holder.minusItem.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             management.MinusNumberOrder(domainPopular_data, position, new ChangeNumberItemListener() {
                 @Override
                 public void changed() {
                     notifyDataSetChanged();
                     changeNumberItemListener.changed();
                 }
             });
         }
     });
    }

    @Override
    public int getItemCount() {
        return domainPopular_data.size();
    }

    class PopularHodler extends RecyclerView.ViewHolder{
        TextView title, feeEachItem, totalEachItem, num;
        ImageView photo , plusItem, minusItem;
        public PopularHodler(@NonNull View itemView) {
            super(itemView);
           title = itemView.findViewById(R.id.Title_card_list_txt);
           feeEachItem = itemView.findViewById(R.id.feeEachItem);
           totalEachItem= itemView.findViewById(R.id.TotalEachItem);
           photo= itemView.findViewById(R.id.photo_cardList);
           num = itemView.findViewById(R.id.numberItem_cardList_txt);
           plusItem= itemView.findViewById(R.id.plusItem_cardList);
           minusItem= itemView.findViewById(R.id.minusItem_cardList);



        }
    }
}
