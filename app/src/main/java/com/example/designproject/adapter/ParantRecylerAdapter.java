package com.example.designproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designproject.Domain.ParentRecylcerView;
import com.example.designproject.R;
import com.example.designproject.RecyclerViewInterface;

import java.util.List;

public class ParantRecylerAdapter extends RecyclerView.Adapter<ParantRecylerAdapter.ParentViewHolder> implements RecyclerViewInterface {
       List<ParentRecylcerView> parentRecylcerViewList;
       Context context;
    public ParantRecylerAdapter(List<ParentRecylcerView> parentRecylcerViewList, Context context ) {
        this.parentRecylcerViewList = parentRecylcerViewList;
        this.context = context;


    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.parent_category_recyclerview, null, false);
        return  new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
             holder.title_parent_recyclerview.setText(parentRecylcerViewList.get(position).title);
             CategoryAdapter categoryAdapter;
             categoryAdapter = new CategoryAdapter(parentRecylcerViewList.get(position).domainCategoryList,this );
             holder.recyclerView_parent.setLayoutManager(new LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL, false));
             holder.recyclerView_parent.setAdapter(categoryAdapter);
             categoryAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return  parentRecylcerViewList.size();
    }

    @Override
    public void onItemClick(int postion) {

    }

    public class ParentViewHolder extends RecyclerView.ViewHolder {
          RecyclerView recyclerView_parent;
          TextView title_parent_recyclerview;
        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView_parent = itemView.findViewById(R.id.recyclerview_parent_item);
            title_parent_recyclerview= itemView.findViewById(R.id.title_category_recyclerview_parent);
        }
    }
}
