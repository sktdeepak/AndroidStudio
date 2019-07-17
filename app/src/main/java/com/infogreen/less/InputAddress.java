package com.infogreen.less;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.Duration;

public class InputAddress extends AppCompatActivity {
   EditText inputText;
    Button buttonSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_address);
        inputText = (EditText) findViewById(R.id.input_address);
        buttonSave = (Button)findViewById(R.id.btnsave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              String val =  String.valueOf(inputText.getText().toString().trim());
                if (!val.equals("")){
                SharedPreferences myPrefs = getSharedPreferences("InfoGreen", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.putString("InfoGreenURLAddress", String.valueOf(inputText.getText().toString().trim()));
                editor.apply();
                PageMove();}
                else{
                    Toast.makeText(getApplicationContext(),"Please enter URL", Toast.LENGTH_LONG).show();
                }
            }} );

        //set up SharedPreferences

    }

    private void PageMove(){
        Intent intent=new Intent(InputAddress.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
