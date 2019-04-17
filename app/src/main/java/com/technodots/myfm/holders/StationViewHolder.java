package com.technodots.myfm.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.technodots.myfm.R;
import com.technodots.myfm.model.Station;

public class StationViewHolder extends RecyclerView.ViewHolder {

    private ImageView mainimage;
    private TextView titleTextView;
    public StationViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mainimage= (ImageView)itemView.findViewById(R.id.main_image);
        this.titleTextView= (TextView)itemView.findViewById(R.id.main_text);
    }

    public void updateUI(Station station){

        String uri=station.getImguri();
        int resource=mainimage.getResources().getIdentifier(uri,null,mainimage.getContext().getPackageCodePath());
        mainimage.setImageResource(resource);

        titleTextView.setText(station.getStationTitle());
    }
}
