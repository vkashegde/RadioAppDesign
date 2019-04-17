package com.technodots.myfm.services;

import com.technodots.myfm.model.Station;

import java.util.ArrayList;

public class DataService {
    private static final DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {
    }

    public ArrayList<Station> getFeaturedStations() {


        //pretended we just downloded from internet

        ArrayList<Station> list = new ArrayList<>();

        list.add(new Station("Flight Plan (Tunes for travel)", "flightplanmusic"));
        list.add(new Station("Two-Whleen(Biking Playlist)", "bicyclemusic"));
        list.add(new Station("Kids Jams(Music for kids)", "kidsmusic"));
        return list;

    }

    public ArrayList<Station> getRecentStations() {

        ArrayList<Station> list = new ArrayList<>();
        return list;
    }


    public ArrayList<Station> getPartyStations() {
        ArrayList<Station> list = new ArrayList<>();
        return list;


    }
}

