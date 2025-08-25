package com.example.navigationdrawer;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        // three of (drawerLayout, navigationView, toolBar) must be there---->
         drawerLayout = findViewById(R.id.main);
         navigationView = findViewById(R.id.navView);
         toolbar = findViewById(R.id.toolbar);

        // step-1 (SET UP TOOLBAR)
       setSupportActionBar(toolbar);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container,new ContactFragment());
        Toast.makeText(this, "Hello Home opened", Toast.LENGTH_SHORT).show();
        ft.commit();



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.w("==========menuItem=================","============Passed===========================================");
                int id = item.getItemId();
                if(id == R.id.home) {
                    Toast.makeText(MainActivity.this, "Pressed on Home", Toast.LENGTH_SHORT).show();
                    setFragment(new HomeFragment());

                }
                else if (id == R.id.contact) {
                    Toast.makeText(MainActivity.this, "Pressed on Contact", Toast.LENGTH_SHORT).show();
                    setFragment(new ContactFragment());

                }
                else if (id == R.id.search) {
                    setFragment(new SettingFragment());
                    Toast.makeText(MainActivity.this, "Pressed on Search", Toast.LENGTH_SHORT).show();
                }
                else if (id == R.id.profile) {
                    Toast.makeText(MainActivity.this, "Pressed on Profile", Toast.LENGTH_SHORT).show();
                    setFragment(new ContactFragment());

                }
                else {
                    Toast.makeText(getApplicationContext() , "Pressed on Others(Setting)", Toast.LENGTH_SHORT).show();
                    setFragment(new SettingFragment());

                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }
/*
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

 */

    private void setFragment(Fragment frag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, frag);
        ft.commit();
    }

}