package com.jimenezict.bicing.getstationstatus.bcnopendata.dto;

import java.util.List;

public class Stations {

    private List<Station> stations;

    public Stations(){

    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}
