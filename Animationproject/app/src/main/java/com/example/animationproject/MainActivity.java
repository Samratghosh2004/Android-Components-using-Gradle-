package com.example.animationproject;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

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


        TextView t;
        Button btnt;
        t = findViewById(R.id.txtvew);
        btnt = findViewById(R.id.btnTranlate);


        Animation  move = AnimationUtils.loadAnimation(MainActivity.this,R.anim.move);
        btnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               t.startAnimation(move);
            }
        });
    }
}