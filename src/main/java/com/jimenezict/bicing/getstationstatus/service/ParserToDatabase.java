package com.jimenezict.bicing.getstationstatus.service;

import com.jimenezict.bicing.getstationstatus.influx.dto.InfluxRegisterDTO;
import com.jimenezict.bicing.getstationstatus.opendata.dto.Station;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParserToDatabase {

    public List<InfluxRegisterDTO> processListOfStationsToGetNumberOfAvailableDocks(List<Station> listOfStation);

    public List<InfluxRegisterDTO> processListOfStationsToGetNumberOfAvailableBikes(List<Station> listOfStation);

    public List<InfluxRegisterDTO> processListOfStationsToGetUsePercentage(List<Station> listOfStation);

}
