package com.infogreen.less;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Screen extends AppCompatActivity {
    Handler handler;
    String urlAdress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

getSupportActionBar().hide();
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                urlAdress = getURLAddress();
                if (urlAdress.equals("")) {
                    Intent intent = new Intent(Splash_Screen.this, InputAddress.class);
                    startActivity(intent);
                    finish();
                } else {
                    PageMove();

                }
            }},2000);

    }
        private String getURLAddress(){

            SharedPreferences myPrefs = getSharedPreferences("InfoGreen", Context.MODE_PRIVATE);
            String urlAddress = myPrefs.getString("InfoGreenURLAddress","");
            return urlAddress;
        }
        private void PageMove(){
            Intent intent=new Intent(Splash_Screen.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
}
