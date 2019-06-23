package com.jimenezict.bicing.getstationstatus.service;

import com.jimenezict.bicing.getstationstatus.influx.InfluxRegister;
import com.jimenezict.bicing.getstationstatus.opendata.dto.Station;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParserToDatabase {

    public List<InfluxRegister> processListOfStationsToGetNumberOfAvailableDocks(List<Station> listOfStation);

    public List<InfluxRegister> processListOfStationsToGetNumberOfAvailableBikes(List<Station> listOfStation);

    public List<InfluxRegister> processListOfStationsToGetUsePercentage(List<Station> listOfStation);

}
