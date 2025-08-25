package com.example.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginPage extends AppCompatActivity {

    AppCompatButton logINbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        logINbtn = findViewById(R.id.login);

        logINbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code to verify

                SharedPreferences p = getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor ed = p.edit();

                ed.putBoolean("flag",true);
                ed.apply();

                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);

            }
        });

    }
}