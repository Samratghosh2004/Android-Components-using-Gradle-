package com.example.database;



import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            MyDBhelper myDBhelper = new MyDBhelper(this);

            myDBhelper.addContact("Ram","9830162110");
           myDBhelper.addContact("Raman","9830162666");
           myDBhelper.addContact("Ramanujan","9830162110");
           myDBhelper.addContact("Ram charan","9830162117");


           /*

           ContactModel contactModel = new ContactModel();
           contactModel.id = 1;
            contactModel.phone = "1234567899";
            myDBhelper.updateContact(contactModel);


            */

        myDBhelper.deleteContact(2);

            ArrayList<ContactModel> array = myDBhelper.showData();
        //for(int i = 0 ; i<= array.size(); i++)
         //   Log.d("DATA BEFORE-------","ID "+array.get(i).id + "name = "+array.get(i).name + " phome "+array.get(i).phone);



            for(int i = 0 ; i<= array.size(); i++)
                Log.d("DATA AFTER-------","ID "+array.get(i).id + " name = "+array.get(i).name + " phome "+array.get(i).phone);

    }
}