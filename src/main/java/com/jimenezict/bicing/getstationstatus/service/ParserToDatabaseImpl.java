package com.jimenezict.bicing.getstationstatus.service;

import com.jimenezict.bicing.getstationstatus.influx.InfluxRegister;
import com.jimenezict.bicing.getstationstatus.opendata.dto.Station;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParserToDatabaseImpl implements ParserToDatabase {

    @Override
    public List<InfluxRegister> processListOfStationsToGetNumberOfAvailableDocks(List<Station> listOfStation) {
        return listOfStation.stream()
                .map(station -> new InfluxRegister(station.getStation_id(), station.getNum_docks_available()))
                .collect(Collectors.toList());
    }

    @Override
    public List<InfluxRegister> processListOfStationsToGetNumberOfAvailableBikes(List<Station> listOfStation) {
        return listOfStation.stream()
                .map(station -> new InfluxRegister(station.getStation_id(), station.getNum_bikes_available()))
                .collect(Collectors.toList());
    }

    @Override
    public List<InfluxRegister> processListOfStationsToGetUsePercentage(List<Station> listOfStation) {
        return listOfStation.stream()
                .map(station -> new InfluxRegister(station.getStation_id(), usageCalculation(station)))
                .collect(Collectors.toList());
    }

    private double usageCalculation(Station station) {
        return (double)(station.getNum_bikes_available()) / (station.getNum_bikes_available() + station.getNum_docks_available());
    }
}
