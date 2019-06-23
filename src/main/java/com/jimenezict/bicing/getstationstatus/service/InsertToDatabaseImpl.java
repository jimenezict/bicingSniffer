package com.jimenezict.bicing.getstationstatus.service;

import com.jimenezict.bicing.getstationstatus.influx.dto.InfluxRegisterDTO;

import java.util.List;

public class InsertToDatabaseImpl implements InsertToDatabase{

    public void insertListOfStationsToGetNumberOfAvailableDocks(List<InfluxRegisterDTO> listOfStation){};

    public void insertListOfStationsToGetNumberOfAvailableBikes(List<InfluxRegisterDTO> listOfStation){};

    public void insertListOfStationsToGetUsePercentage(List<InfluxRegisterDTO> listOfStation){};
}
