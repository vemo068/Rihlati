package com.appapp26.rihlati;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.appapp26.rihlati.ui.login.LoginActivity;

public class TripInfo extends AppCompatActivity {
    Button res_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_trip_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        res_button=findViewById(R.id.res_button);
      // Intent i=getIntent();
     // Trip trip=i.getParcelableExtra(SearchResault.EXTRA_ID);
        TextView time=findViewById(R.id.time);
      //  time.setText(trip.time);
        res_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "you booked this trip", Toast.LENGTH_LONG).show();
                Intent i = new Intent(TripInfo.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
    }
