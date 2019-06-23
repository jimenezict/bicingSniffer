package com.jimenezict.bicing.getstationstatus.service;

import com.jimenezict.bicing.getstationstatus.influx.dto.InfluxRegisterDTO;

import java.util.List;

public interface InsertToDatabase {

    public void insertListOfStationsToGetNumberOfAvailableDocks(List<InfluxRegisterDTO> listOfStation);

    public void insertListOfStationsToGetNumberOfAvailableBikes(List<InfluxRegisterDTO> listOfStation);

    public void insertListOfStationsToGetUsePercentage(List<InfluxRegisterDTO> listOfStation);
}
