package com.appapp26.rihlati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import com.google.android.filament.Box;

import java.io.Serializable;

public class SearchResault extends AppCompatActivity {
    public static String EXTRA_ID="extratrip";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_resault);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       // System.out.println(av_places.getText().toString()+distination.getText().toString()+time.getText().toString());

    }
    public void cardClick(View view) {
        TextView av_places=findViewById(R.id.places);

        TextView time=findViewById(R.id.time);
        TextView distination=findViewById(R.id.desti);
        int price=60;
        //Intent I = new Intent(this, TripInfo.class);
        Trip trip=new Trip(av_places.getText().toString(),distination.getText().toString(),time.getText().toString(),price);

        Intent i = new Intent(this, TripInfo.class);

       // i.putExtra(EXTRA_ID, (Parcelable) trip);
        startActivity(i);
    }
}