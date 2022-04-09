package com.appapp26.rihlati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseToEditScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_to_edit_screen);
    }
    public void cardClick(View view){
        Intent i = new Intent(this,EditScreen.class);
        startActivity(i);
    }
}