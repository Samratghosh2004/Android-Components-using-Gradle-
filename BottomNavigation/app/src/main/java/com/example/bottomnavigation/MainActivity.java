package com.example.bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FrameLayout fl ;
    BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bottomNav);


        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if(id == R.id.navHome) {
                    selectFragment(new HomeFragment(),false);
                }
                else if(id == R.id.navSearch) {
                    selectFragment(new SearchFragment(),false);
                }
                else if(id == R.id.navContact) {
                    selectFragment(new ContactFragment(),false);
                }
                else {   // profile
                    selectFragment(new ProfileFragment(),true);
                }
                return true;
            }
        });
        bnv.setSelectedItemId(R.id.navProfile);

    }
    void selectFragment(Fragment frag , boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft  = fm.beginTransaction();
        if(flag == true) {
        ft.add(R.id.framelayout,frag);
        }
        else {
            ft.replace(R.id.framelayout,frag);
        }
        ft.commit();
    }
}