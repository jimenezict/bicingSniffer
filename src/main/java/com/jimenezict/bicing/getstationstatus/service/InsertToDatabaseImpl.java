package com.jimenezict.bicing.getstationstatus.service;

import com.jimenezict.bicing.getstationstatus.influx.InfluxRegisterDAO;
import com.jimenezict.bicing.getstationstatus.influx.dto.InfluxRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsertToDatabaseImpl implements InsertToDatabase{

    @Autowired
    InfluxRegisterDAO influxRegisterDAO;

    public void insertListOfStationsToGetNumberOfAvailableDocks(List<InfluxRegisterDTO> listOfStation){
        influxRegisterDAO.insertListOfInfluxRegisterDTOsByMeasure("availabledocks",listOfStation);
    };

    public void insertListOfStationsToGetNumberOfAvailableBikes(List<InfluxRegisterDTO> listOfStation){
        influxRegisterDAO.insertListOfInfluxRegisterDTOsByMeasure("availablebikes",listOfStation);
    }

    public void insertListOfStationsToGetUsePercentage(List<InfluxRegisterDTO> listOfStation){
        influxRegisterDAO.insertListOfInfluxRegisterDTOsByMeasure("usepercentage",listOfStation);
    };
}
