package com.appapp26.rihlati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.appapp26.rihlati.Db.DatabaseHelper;

public class YourTrips extends AppCompatActivity {
    DatabaseHelper db;
    RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_trips);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db =  DatabaseHelper.getInstance(getApplicationContext(),null,null,1);
        rcv=findViewById(R.id.rcv_all);
        CardAdapter cardAdapter= new CardAdapter(db.getAllTrips());
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv.addItemDecoration(dividerItemDecoration);
        rcv.setLayoutManager(llm);
        rcv.setAdapter(cardAdapter);
    }
}