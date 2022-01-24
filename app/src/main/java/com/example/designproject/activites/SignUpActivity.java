package com.example.designproject.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.designproject.Fragments.MyAccountFragment;
import com.example.designproject.R;

public class SignUpActivity extends AppCompatActivity {
    TextView login , forgotpass;
    EditText password , email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        login = findViewById(R.id.login_txt_inSignUp_page);
        forgotpass = findViewById(R.id.forgot_password);
        password = findViewById(R.id.et_password);
        email = findViewById(R.id.et_password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setVisibility(View.GONE);

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.constraint_sigup , new MyAccountFragment()).commit();
            }
        });
    }
}