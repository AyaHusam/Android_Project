package com.example.designproject.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.designproject.Domain.DomainCategory;
import com.example.designproject.Domain.DomainFashion;
import com.example.designproject.R;
import com.example.designproject.activites.ShowDetailActivity;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularHodler> {
    ArrayList<DomainFashion> domainPopular_data;
    public PopularAdapter(ArrayList<DomainFashion> domainPopular_data) {
        this.domainPopular_data = domainPopular_data;
    }

    @NonNull
    @Override
    public PopularHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_popular_layout,parent,false);
        return new PopularHodler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  PopularHodler holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(domainPopular_data.get(position).getTitle());
        holder.fee.setText(String.valueOf(domainPopular_data.get(position).getFee()));
        int drawableResourceId= holder.itemView.getContext().getResources().getIdentifier(domainPopular_data.get(position).getPhoto(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.photo);
        holder.add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("Object_data_from_popular", domainPopular_data.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return domainPopular_data.size();
    }

    class PopularHodler extends RecyclerView.ViewHolder{
        TextView title, fee, add_btn;
        ImageView photo;
        public PopularHodler(@NonNull View itemView) {
            super(itemView);
           title = itemView.findViewById(R.id.title_popular_layut);
           fee = itemView.findViewById(R.id.fee_popular_layout);
           add_btn= itemView.findViewById(R.id.add_btn_popular_layout);
           photo= itemView.findViewById(R.id.image_popular_layout);


        }
    }
}
