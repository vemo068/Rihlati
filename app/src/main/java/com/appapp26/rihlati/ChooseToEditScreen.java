package com.appapp26.rihlati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.appapp26.rihlati.Db.DatabaseHelper;

public class ChooseToEditScreen extends AppCompatActivity {
RecyclerView rcv;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_to_edit_screen);
        db =  DatabaseHelper.getInstance(getApplicationContext(),null,null,1);
        rcv=findViewById(R.id.rcv_choose);
        CardAdapter cardAdapter= new CardAdapter(db.getAllTrips());
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv.addItemDecoration(dividerItemDecoration);
        rcv.setLayoutManager(llm);
        rcv.setAdapter(cardAdapter);
    }
    public void cardClick(View view){
        Intent i = new Intent(this,EditScreen.class);
        startActivity(i);
    }
}