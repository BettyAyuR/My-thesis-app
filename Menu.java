package com.example.loginregistration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        CardView showDaftar = findViewById(R.id.daftar);
        CardView showDiagnosa = findViewById(R.id.diagnosa2);
        CardView showAbout = findViewById(R.id.about);
        CardView showCekRiwayat = findViewById(R.id.cekriwayat);

        showDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, ListPenyakit.class);
                startActivity(intent);
            }
        });
        showDiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, biodata.class);
                startActivity(intent);
            }
        });
        showAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, AboutActivity.class);
                startActivity(intent);
            }
        });
       showCekRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}