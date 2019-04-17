package com.technodots.myfm.model;

public class Station  {
    final String DRAWBLE = "drawable/";
    private String stationTitle;
    private String imguri;

    public Station(String stationTitle, String imguri) {
        this.stationTitle=stationTitle;
        this.imguri = imguri;
    }

    public String getStationTitle() {
        return stationTitle;
    }


    public String getImguri() {
        return DRAWBLE + imguri;
    }

}
