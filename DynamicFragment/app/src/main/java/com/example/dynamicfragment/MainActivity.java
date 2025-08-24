package com.example.dynamicfragment;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.sax.RootElement;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {


    private String RootElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOne = findViewById(R.id.one);
        Button btnTwo = findViewById(R.id.two);
        Button btnThree = findViewById(R.id.three);

        setFragment(new AFragment(),false);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setFragment(new AFragment(),true);
            }
        });


        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new BFragment(),false);
            }
        });


        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new CFragment(), false);
            }
        });

    }


    public void setFragment(Fragment f, boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag) {
            fm.popBackStack(RootElement, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack(RootElement);
            Bundle b = new Bundle();
            b.putString("Name", "Samrat Ghosh");
            b.putInt("Roll", 29);


            f.setArguments(b);

            ft.add(R.id.container, f);
        }
        else {
            ft.replace(R.id.container, f);
            ft.addToBackStack(null);
        }

        ft.commit();
    }



    public void callFromFragment() {
        Log.d("Value","Calling From Fragment");
    }
}