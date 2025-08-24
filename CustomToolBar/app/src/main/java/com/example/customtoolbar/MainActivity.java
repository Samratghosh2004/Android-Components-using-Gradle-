package com.example.customtoolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //STEP -1
        toolbar  = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //STEP -2
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //STEP-3
        toolbar.setTitle("My App");
        toolbar.setSubtitle("This is subtitle");



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemSet = item.getItemId();
        if(itemSet == R.id.opt_new) {
            Toast.makeText(this, "Pressed on New", Toast.LENGTH_SHORT).show();
        } else if (itemSet == R.id.opt_open) {
            Toast.makeText(this, "Pressed on Open", Toast.LENGTH_SHORT).show();
        }
        else if (itemSet == R.id.opt_save) {
            Toast.makeText(this, "Pressed on save", Toast.LENGTH_SHORT).show();
        } else if (itemSet == android.R.id.home) {
            Toast.makeText(this, "Pressed on Home (android.R.id.home)", Toast.LENGTH_SHORT).show();
        } else {

        }
        return super.onOptionsItemSelected(item);
    }



}