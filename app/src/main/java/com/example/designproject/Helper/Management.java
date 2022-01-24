package com.example.designproject.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.designproject.Domain.DomainFashion;
import com.example.designproject.Interface.ChangeNumberItemListener;

import java.util.ArrayList;

public class Management {
    private Context context;
    private TinyDB tinyDB;
    public Management (Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
        public void insertOrder(DomainFashion item){
            ArrayList<DomainFashion> listOrder = getListCard();
            boolean existAlready = false;
            int n=0;
            for (int i=0; i< listOrder.size();i++){
                if(listOrder.get(i).getTitle().equals(item.getTitle())){;
                existAlready = true;
                n=i;
                break;
            }
            }
            if(existAlready){
                listOrder.get(n).setNumberInCard(item.getNumberInCard());
            }
            else {
                listOrder.add(item);
            }
            tinyDB.putListObject("CardList", listOrder);
            Toast.makeText(context, "Added To Your Card", Toast.LENGTH_SHORT).show();
        }
        public  ArrayList<DomainFashion> getListCard(){
        return tinyDB.getListObject("CardList");
        }
        public void plusNumberOrder(ArrayList<DomainFashion>listOrder, int position , ChangeNumberItemListener changeNumberItemListener){
            listOrder.get(position).setNumberInCard(listOrder.get(position).getNumberInCard());
            tinyDB.putListObject("CardList" , listOrder);

            changeNumberItemListener.changed();

        }
        public  void MinusNumberOrder(ArrayList<DomainFashion> listOrder , int position, ChangeNumberItemListener changeNumberItemListener){
        if(listOrder.get(position).getNumberInCard()==1){
            listOrder.remove(position);
        }else{
            listOrder.get(position).setNumberInCard(listOrder.get(position).getNumberInCard()-1);
        }
          tinyDB.putListObject("CardList", listOrder);
        changeNumberItemListener.changed();
        }
        public Double getTotalFee(){
        ArrayList<DomainFashion> listOrder2= getListCard();
        double fee=0;
        for(int i = 0 ; i < listOrder2.size() ; i++){
            fee = fee + (listOrder2.get(i).getFee() * listOrder2.get(i).getNumberInCard());
        }
        return fee;
        }
}
