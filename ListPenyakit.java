package com.example.loginregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ListPenyakit extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_penyakit);
            WebView myWeb = findViewById(R.id.webView);
            myWeb.setWebViewClient(new WebViewClient());
            myWeb.loadUrl("https://www.alodokter.com/macam-macam-dermatitis-yang-perlu-anda-ketahui");
            WebSettings webSettings = myWeb.getSettings();
            webSettings.setJavaScriptEnabled(true);
        }
    }