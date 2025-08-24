package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //   (1)
        // taking variables
        EditText weight, heightft, heightinch;
        TextView res;
        Button btn;
        LinearLayout lmain;

        //   (2)
        // assgning the veriables with their corresponding designing elements
        weight = findViewById(R.id.edit_text_weight);
        heightft = findViewById(R.id.edit_text_height_ft);
        heightinch = findViewById(R.id.edit_text_height_inch);
        res = findViewById(R.id.result_textview);
        btn = findViewById(R.id.btn_calculate);
        lmain = findViewById(R.id.main);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //   (3)
                // now fetch the value of the intigers from the existing elements
               // As the values are not in intiger at the time of getting, it need to convert in integer through the java technique
                int wt = Integer.parseInt(weight.getText().toString());
                int htf =Integer.parseInt(heightft.getText().toString());
                int hti = Integer.parseInt(heightinch.getText().toString());


                int total_Inch  = htf*12 + hti;

                double total_cm = total_Inch*2.53;

                double total_m = total_cm/100;

                double bmi = wt/(total_m * total_m);

                lmain.setBackgroundColor(getResources().getColor(R.color.Yellow));

                if(bmi>25) {
                    res.setText("You are OverWeight !!");
                    res.setBackgroundColor(getResources().getColor(R.color.Red));
                } else if (bmi<18) {
                    res.setText("You are UnderWeight !!");
                    res.setBackgroundColor(getResources().getColor(R.color.Red));
                } else {
                    res.setText("You are Normal :) ");
                    res.setBackgroundColor(getResources().getColor(R.color.Green));
                }


            }
        });

    }
}