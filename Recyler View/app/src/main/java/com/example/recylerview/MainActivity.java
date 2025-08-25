package com.example.recylerview;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //---= GLOBAL DECLARATION =---------
RecyclerContactAdapter rAdaptor;
RecyclerView rv;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Creating the ArrayList of Structure Class, where the list of data in structured classed can be stored
        ArrayList<contactMedel> cm = new ArrayList<>();

        //Creating RecyclerView
        rv = findViewById(R.id.recyler_view);
        // Setting the layout manager in which format the data will be shown
        rv.setLayoutManager(new LinearLayoutManager(this));;

//==========================    INSERTION OF ELEMENTS IN RECYCLER VIEW IN RUN TIME=============================
        FloatingActionButton faButton = findViewById(R.id.btnDialog);



        faButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update);
                EditText input_name = dialog.findViewById(R.id.input_name);
                EditText input_phone = dialog.findViewById(R.id.input_number);
                Button input_button = dialog.findViewById(R.id.input_btn);


                input_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = input_name.getText().toString();
                        String phone  = input_phone.getText().toString();
                        cm.add(new contactMedel(name,phone));

                        //=====  Something error occurred for the next line ======
                        //rAdaptor.notifyItemInserted(cm.size()-1);
                        rv.scrollToPosition(cm.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });






        // Creating the object of Structure class
       // contactMedel c = new contactMedel(R.drawable.ic_launcher_background,"Samrat Ghosh","9830162110");
        //cm.add(c);
        cm.add(new contactMedel(R.drawable.ic_launcher_background,"Rahul Roy","7834973938"));
        cm.add(new contactMedel(R.drawable.ic_launcher_background,"Shreyoshi Das","8564027746"));
        cm.add(new contactMedel(R.drawable.ic_launcher_background,"Abir Dey","9586302001"));
        cm.add(new contactMedel(R.drawable.ic_launcher_background,"Debjeet Das","9753168277"));
        cm.add(new contactMedel(R.drawable.ic_launcher_background,"Arnab Debnath","7834973938"));
        cm.add(new contactMedel(R.drawable.ic_launcher_background,"Sayan Pal","7240387510"));


        RecyclerContactAdapter rAdaptor = new RecyclerContactAdapter(this,cm);
        rv.setAdapter(rAdaptor);
    }
}