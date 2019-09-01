package com.jimenezict.bicing.getstationstatus.service;

import com.jimenezict.bicing.getstationstatus.influx.dto.InfluxRegisterDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InsertToDatabase {

    void insertListOfStationsToGetNumberOfAvailableDocks(List<InfluxRegisterDTO> listOfStation);

    void insertListOfStationsToGetNumberOfAvailableBikes(List<InfluxRegisterDTO> listOfStation);

    void insertListOfStationsToGetUsePercentage(List<InfluxRegisterDTO> listOfStation);
}
