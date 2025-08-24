package com.example.customtoast;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
        // Default Toast---->
       // Toast.makeText(this, "", Toast.LENGTH_LONG).show();

        // Customising Toast
        Toast toast = new Toast(this);

        View v = getLayoutInflater().inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.viewContainer));
        toast.setView(v);


       // toast.setText("");

        TextView tv = v.findViewById(R.id.txt);
        tv.setText("Messag sent successfully");



        //Duration
        toast.setDuration(Toast.LENGTH_LONG);

        //Set Gravity
        toast.setGravity(Gravity.TOP|Gravity.END,0,0);

        //To reveal
        toast.show();
    }
}