package com.appapp26.rihlati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
RecyclerView rcv;
Button my_trips_btn;
Button search_btn;
FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my_trips_btn= findViewById(R.id.mytrips_btn);
        search_btn=findViewById(R.id.srh_btn);
        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AdminPage.class);
                startActivity(i);
            }
        });
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SearchResault.class);
                startActivity(i);
            }
        });
        my_trips_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,YourTrips.class);
                startActivity(i);
            }
        });
      //  rcv=findViewById(R.id.recent_scroll);
        CardAdapter mycard= new CardAdapter();

       // rcv.setAdapter(mycard);
       // rcv.setLayoutManager(new LinearLayoutManager(getBaseContext()));

    }

    public void cardClick(View view) {

        Intent i = new Intent(MainActivity.this,TripInfo.class);
        startActivity(i);
    }
}