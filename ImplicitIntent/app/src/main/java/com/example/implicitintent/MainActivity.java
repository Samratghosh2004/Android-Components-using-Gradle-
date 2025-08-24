package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    Button btnDial, btnMsg, btnEmail, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDial = findViewById(R.id.one);
        btnMsg = findViewById(R.id.two);
        btnEmail = findViewById(R.id.three);
        btnShare = findViewById(R.id.four);


        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +91 9830162110"));
                startActivity(iDial);
            }
        });


        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:"+Uri.encode("+91 9830162110")));
                iMsg.putExtra("sms_body", "Hey!!! Whats going on??");
                startActivity(iMsg);
            }
        });


        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
               iEmail.setType("message/rfc822");
                //startActivity(iEmail);
                iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"samratgh2004@gmail.com","rahulop1993@gmail.com","xyz@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"SUBJECT");
                iEmail.putExtra(Intent.EXTRA_TEXT,"message: contact us");
                startActivity(Intent.createChooser(iEmail,"Email via"));
            }
        });



        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"join on google https://www.google.com");
                startActivity(iShare);
            }
        });

    }
}