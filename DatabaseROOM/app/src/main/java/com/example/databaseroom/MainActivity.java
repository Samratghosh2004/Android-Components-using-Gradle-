package com.example.databaseroom;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText first, second;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = findViewById(R.id.firstEdit);
        second = findViewById(R.id.secondEdit);
        btn = findViewById(R.id.submitBtn);


        DataBaseHelper dataBaseHelper = DataBaseHelper.getDB(this);

        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String title = first.getText().toString();
                String amount = second.getText().toString();
                dataBaseHelper.expenseDAO().addData(
                        new Expense(title,amount)
                );

                ArrayList<Expense>arr = (ArrayList<Expense>)dataBaseHelper.expenseDAO().getData();
                for(int i = 0;i<arr.size();i++) {
                    Log.d("====Data==============================", "Title " + arr.get(i).getTitle() +" Value " + arr.get(i).getAmount());
                }

            }
        });


    }
}