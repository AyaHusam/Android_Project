package com.example.designproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designproject.Domain.DomainCategory;
import com.example.designproject.R;
import com.example.designproject.RecyclerViewInterface;

import java.util.List;

public class CategoryAdapter  extends RecyclerView.Adapter<CategoryAdapter.categoryHodler> {
    List<DomainCategory> domainCategories_data;
    Context context;
    private final  RecyclerViewInterface recyclerViewInterface;

    public  CategoryAdapter(List<DomainCategory> domainCategoryList, RecyclerViewInterface recyclerViewInterface){
        this.domainCategories_data = domainCategoryList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    /*public CategoryAdapter(List<DomainCategory> domainCategories_data, Context context , RecyclerViewInterface recyclerViewInterface ) {
        this.domainCategories_data = domainCategories_data;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;

    }
*/
    @NonNull
    @Override
    public categoryHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_category_layout,parent,false);
        return new categoryHodler(v , recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryHodler holder, int position) {
        holder.category_name.setText(domainCategories_data.get(position).getTitle());
        holder.catergory_photo.setImageResource(domainCategories_data.get(position).getPhoto());
        holder.btn_price.setText(domainCategories_data.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return domainCategories_data.size();
    }

    class categoryHodler extends RecyclerView.ViewHolder{
        TextView category_name;
        ImageView catergory_photo;
        LinearLayout main_loyout;
        Button btn_price;

        public categoryHodler(@NonNull View itemView , RecyclerViewInterface recyclerViewInterface ) {
            super(itemView);
            category_name = itemView.findViewById(R.id.title_category_layout);
            catergory_photo = itemView.findViewById(R.id.photo_category_layout);
            main_loyout = itemView.findViewById(R.id.mainlayout);
            btn_price = itemView.findViewById(R.id.btn_price_category_layout_view_holder);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        recyclerViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }
}
