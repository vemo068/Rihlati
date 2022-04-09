package com.appapp26.rihlati;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class YourTrips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_trips);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}