package com.example.customdialogbox;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);


        btn = dialog.findViewById(R.id.btn);

dialog.setCancelable(false);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Pressed", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }
});
        dialog.show();

    }
}