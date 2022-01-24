package com.example.designproject.Fragments;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.designproject.R;
import com.example.designproject.activites.SignUpActivity;

public class MyAccountFragment extends Fragment {
    @Nullable
    @Override
    public View  onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.myaccountfragment, container, false);
        TextView Sigup = (TextView) view.findViewById(R.id.create);
        Sigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext() ,SignUpActivity.class);
                startActivity(intent);
            }
        });
           return view;

    }

}
