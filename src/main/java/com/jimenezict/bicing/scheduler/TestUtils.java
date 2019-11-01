package com.jimenezict.bicing.scheduler;

import com.jimenezict.bicing.bcnopendata.dto.Station;
import com.jimenezict.bicing.bcnopendata.dto.StationStatus;
import com.jimenezict.bicing.bcnopendata.dto.Stations;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static StationStatus buildStationStatus(){
        StationStatus stationStatus = new StationStatus();
        List<Station> stationList  = new ArrayList<>(0);
        stationList.add(station(10, 10, 1));
        stationList.add(station(10, 10, 2));
        stationList.add(station(10, 10, 3));
        Stations stations = new Stations();
        stations.setStations(stationList);

        stationStatus.setLast_updated(1l);
        stationStatus.setTtl(30);
        stationStatus.setData(stations);

        return stationStatus;
    }

    public static Station station(int availabe, int docks, int stationId){
        Station station = new Station();
        station.setNum_bikes_available(availabe);
        station.setNum_docks_available(docks);
        station.setStation_id(1);
        return station;
    }
}
