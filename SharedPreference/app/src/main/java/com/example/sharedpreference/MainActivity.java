package com.example.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences p = getSharedPreferences("login",MODE_PRIVATE);
                Boolean check = p.getBoolean("flag",false);

                Intent i ;

                if(check) {
                    i= new Intent(getApplicationContext(), Home.class);
                }else {
                    i = new Intent(getApplicationContext(), LoginPage.class);
                }
                startActivity(i);


            }
        },3000);

    }
}