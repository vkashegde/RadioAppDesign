package com.technodots.myfm.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.technodots.myfm.R;
import  com.technodots.myfm.R;
import com.technodots.myfm.holders.StationViewHolder;
import com.technodots.myfm.model.Station;

import java.util.ArrayList;

public class StationAdapter extends RecyclerView.Adapter<StationViewHolder> {

    private ArrayList<Station> stations;

    public StationAdapter(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @Override
    public void onBindViewHolder(@NonNull StationViewHolder holder, int position) {

        Station station = stations.get(position);
        holder.updateUI(station);


    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    @NonNull
    @Override
    public StationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View statioCard = LayoutInflater .from(parent.getContext()).inflate(R.layout.card_station,parent,false);


        return new StationViewHolder(statioCard);
    }
}
