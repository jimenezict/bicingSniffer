package com.jimenezict.bicing.getstationstatus.service;

import com.jimenezict.bicing.getstationstatus.influx.dto.InfluxRegisterDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InsertToDatabase {

    public void insertListOfStationsToGetNumberOfAvailableDocks(List<InfluxRegisterDTO> listOfStation);

    public void insertListOfStationsToGetNumberOfAvailableBikes(List<InfluxRegisterDTO> listOfStation);

    public void insertListOfStationsToGetUsePercentage(List<InfluxRegisterDTO> listOfStation);
}
