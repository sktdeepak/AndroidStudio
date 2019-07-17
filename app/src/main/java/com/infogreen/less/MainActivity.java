package com.infogreen.less;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
WebView mWebView;
    private ProgressBar spinner;
    SwipeRefreshLayout mySwipeRefreshLayout;
    String urlAdress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlAdress = getURLAddress();

            mWebView = (WebView) findViewById(R.id.activity_main_webview);
            spinner = (ProgressBar) findViewById(R.id.progressBar1);
            mySwipeRefreshLayout = (SwipeRefreshLayout) this.findViewById(R.id.swipeContainer);


            getSupportActionBar().hide();
            WebSettings webSettings = mWebView.getSettings();
            mWebView.setWebViewClient(new AppWebViewClients(spinner));
            mWebView.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
            webSettings.setJavaScriptEnabled(true);
            mWebView.loadUrl(urlAdress);

            mySwipeRefreshLayout.setOnRefreshListener(
                    new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            mySwipeRefreshLayout.setRefreshing(true);
                            (new Handler()).postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mySwipeRefreshLayout.setRefreshing(false);
                                    mWebView.reload();
                                }
                            }, 2000);
                        }

                        // mySwipeRefreshLayout.set.set..setRefreshing(false); //this line hides the refresh button after completing
                    }


            );

        }


    private String getURLAddress(){

        SharedPreferences myPrefs = getSharedPreferences("InfoGreen", Context.MODE_PRIVATE);
        String urlAddress = myPrefs.getString("InfoGreenURLAddress","");
        return urlAddress;
    }
    private void PageMove(){
        Intent intent=new Intent(MainActivity.this,InputAddress.class);
        startActivity(intent);
        finish();
    }
}
