package com.appapp26.rihlati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditScreen extends AppCompatActivity {
    Button edit_btn;
    Button delete_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_screen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edit_btn=findViewById(R.id.edit_btn);
        delete_btn=findViewById(R.id.delete_btn);
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Trip edited", Toast.LENGTH_LONG).show();
                Intent i = new Intent(EditScreen.this, AdminPage.class);
                startActivity(i);
            }
        });
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Trip deleted", Toast.LENGTH_LONG).show();
                Intent i = new Intent(EditScreen.this, AdminPage.class);
                startActivity(i);
            }
        });
    }
}