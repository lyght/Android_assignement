package com.example.gallien.assignement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class show_web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_web);

        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl("http://www.google.com");
    }
}
