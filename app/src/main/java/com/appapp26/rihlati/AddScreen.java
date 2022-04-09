package com.appapp26.rihlati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddScreen extends AppCompatActivity {
Button save_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        save_btn=findViewById(R.id.save_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Trip Added", Toast.LENGTH_LONG).show();
                Intent i = new Intent(AddScreen.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}