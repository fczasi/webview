package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private WebView zschie;
    private Button goback, reloadsite, zomin, zomout, forwardbutt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goback = findViewById(R.id.goback);
        reloadsite = findViewById(R.id.reloadsite);
        zomin = findViewById(R.id.zomin);
        zomout = findViewById(R.id.zomout);
        forwardbutt = findViewById(R.id.forwardbutt);
        zschie = findViewById(R.id.zschie);

        zschie.setWebViewClient(new WebViewClient());
        zschie.loadUrl("https://zschie.pl/");

        zomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zschie.zoomIn();
            }
        });
        zomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zschie.zoomOut();
            }
        });
        reloadsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zschie.reload();
            }
        });

        forwardbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                zschie.goForward();
            }
        });
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zschie.goBack();
            }
        });
        WebSettings webSettings=zschie.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    @Override
    public void onBackPressed() {
        if(zschie.canGoBack()){
            zschie.goBack();

        }else{
            super.onBackPressed();
        }


    }

}