package com.example.loginregistration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppStartActivity extends AppCompatActivity {

    Button logout,btnhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("App Start Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
        btnhome = findViewById(R.id.btnhome);
        logout = findViewById(R.id.logout);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(getResources().getString(R.string.prefLoginState),"loggedout");
                editor.apply();
                startActivity(new Intent(AppStartActivity.this,MainActivity.class));
                finish();
            }

        });
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AppStartActivity.this,Menu.class));
            }
        });

    }
}
