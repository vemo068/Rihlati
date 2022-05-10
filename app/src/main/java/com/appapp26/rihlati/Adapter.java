package com.appapp26.rihlati;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.appapp26.rihlati.databinding.BusCardBinding;

import java.util.ArrayList;
import java.util.List;

class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private List<Trip> trips;

    public CardAdapter(List<Trip> trips){
        this.trips=trips;
    }

    public void cardClick(){





    }
    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        BusCardBinding busCardBinding= BusCardBinding.inflate(layoutInflater,parent,false);
        return  new ViewHolder(busCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
       Trip trip = trips.get(position);
       holder.busCardBinding.executePendingBindings();
       holder.busCardBinding.setTrip(trip);
    }

    @Override
    public int getItemCount() {
        return this.trips.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        BusCardBinding busCardBinding;


        public ViewHolder(@NonNull BusCardBinding busCardBinding) {
            super(busCardBinding.getRoot());
            busCardBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Trip trip=busCardBinding.getTrip();

                }
            });
            this.busCardBinding=busCardBinding;
        }
        void  vv(){

        }

    }
}
