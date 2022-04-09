package com.appapp26.rihlati;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private ArrayList<Trip> list = new ArrayList();

    public void addItems( ArrayList<Trip> list){
        this.list = list;
    }

    public void cardClick(View view){
       System.out.println("hello card");

    }
    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_card,parent,false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
         holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
         TextView from = itemView.findViewById(R.id.from);
         TextView to = itemView.findViewById(R.id.to);
         TextView time = itemView.findViewById(R.id.time);
         TextView avP = itemView.findViewById(R.id.places);

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @SuppressLint("SetTextI18n")
        public void bind(Trip trip){
       from.setText("Eloued");
       to.setText(trip.distination);
       time.setText(trip.time);
       avP.setText(trip.av_places);
        }
    }
}
