package com.appapp26.rihlati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.appapp26.rihlati.Db.DatabaseHelper;
import com.google.android.filament.Box;

import java.io.Serializable;
import java.util.List;

public class SearchResault extends AppCompatActivity {
   String destination;
   TextView text;
    DatabaseHelper db;
    RecyclerView rcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_resault);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extras = getIntent().getExtras();
        db =  DatabaseHelper.getInstance(getApplicationContext(),null,null,1);
        if (extras != null) {
            destination = extras.getString("key");

            //The key argument here must match that used in the other activity
        }




        text=(TextView) findViewById(R.id.res_title);
        text.setText("Trips to "+destination);
        System.out.println(destination);

//
        rcv=findViewById(R.id.search_rcv);

        List<Trip> resultTrips = db.getSearchTrips(destination);
        CardAdapter cardAdapter= new CardAdapter(resultTrips);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv.addItemDecoration(dividerItemDecoration);
        rcv.setLayoutManager(llm);
        rcv.setAdapter(cardAdapter);



//
//        System.out.println(resultTrips.size());
//        for (Trip trip : resultTrips) {
//            System.out.println("DDD"+trip.getTime());
//        }
       // System.out.println(av_places.getText().toString()+distination.getText().toString()+time.getText().toString());

    }
    public void cardClick(View view) {


        //Intent I = new Intent(this, TripInfo.class);
       // Trip trip=new Trip(Integer.parseInt((String) av_places.getText()).toString(),distination.getText().toString(),time.getText().toString(),price);

        Intent i = new Intent(this, TripInfo.class);

       // i.putExtra(EXTRA_ID, (Parcelable) trip);
        startActivity(i);
    }
}