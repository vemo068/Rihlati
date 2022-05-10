package com.appapp26.rihlati;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.appapp26.rihlati.Db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView rcv;
Button my_trips_btn;
Button search_btn;
FloatingActionButton fab;
    DatabaseHelper db;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db =  DatabaseHelper.getInstance(getApplicationContext(),null,null,1);

        Trip trip1 = new Trip(20,"Tebessa","11:00",600);
        Trip trip2 = new Trip(25,"Alger","19:00",1200);
        Trip trip3 = new Trip(19,"Ouregla","16:00",500);
        Trip trip4 = new Trip(15,"Tebessa","08:00",600);

        long trip1_id=db.createTrip(trip1);
        long trip2_id=db.createTrip(trip2);
        long trip3_id=db.createTrip(trip3);
        long trip4_id=db.createTrip(trip4);



        Log.d("Tag Count", "Tag Count: " + db.getAllTrips().size());

        rcv=findViewById(R.id.recent_rcv);
        CardAdapter cardAdapter= new CardAdapter(db.getRecentTrips());
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv.addItemDecoration(dividerItemDecoration);
        rcv.setLayoutManager(llm);
        rcv.setAdapter(cardAdapter);

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
                EditText text = (EditText)findViewById(R.id.search_distination);
                String value = text.getText().toString();

                Intent i = new Intent(MainActivity.this,SearchResault.class);
                i.putExtra("key",value);

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


    }

    public void cardClick(View view) {


        Intent i = new Intent(MainActivity.this,TripInfo.class);
        startActivity(i);
    }
}