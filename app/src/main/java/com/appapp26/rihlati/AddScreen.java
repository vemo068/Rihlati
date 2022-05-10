package com.appapp26.rihlati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.appapp26.rihlati.Db.DatabaseHelper;

public class AddScreen extends AppCompatActivity {
Button save_btn;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db =  DatabaseHelper.getInstance(getApplicationContext(),null,null,1);
        save_btn=findViewById(R.id.save_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText price=findViewById(R.id.price_text);
                int tripPrice = Integer.parseInt(price.getText().toString());
                EditText places=findViewById(R.id.n_pleces_text);
                int tripPlaces = Integer.parseInt(places.getText().toString());
                EditText destination = (EditText)findViewById(R.id.destinatin_text);
                String tripDestinaton = destination.getText().toString();
                EditText time = (EditText)findViewById(R.id.time_text);
                String tripTime = time.getText().toString();
                Trip newTrip=new Trip(tripPlaces,tripDestinaton,tripTime,tripPrice);
                db.createTrip(newTrip);
                Toast.makeText(getApplicationContext(), "Trip Added", Toast.LENGTH_LONG).show();
                Intent i = new Intent(AddScreen.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}