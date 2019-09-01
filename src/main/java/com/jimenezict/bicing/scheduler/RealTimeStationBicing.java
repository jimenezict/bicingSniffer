package com.jimenezict.bicing.scheduler;

import com.jimenezict.bicing.getstationstatus.influx.dto.InfluxRegisterDTO;
import com.jimenezict.bicing.bcnopendata.BicingApiCall;
import com.jimenezict.bicing.bcnopendata.dto.Station;
import com.jimenezict.bicing.bcnopendata.dto.StationStatus;
import com.jimenezict.bicing.getstationstatus.service.InsertToDatabase;
import com.jimenezict.bicing.getstationstatus.service.ParserToDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class RealTimeStationBicing {

    private static final Logger log = LoggerFactory.getLogger(RealTimeStationBicing.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private BicingApiCall bicingApiCall;

    @Autowired
    private ParserToDatabase parserToDatabase;

    @Autowired
    private InsertToDatabase insertToDatabase;

    @Scheduled(fixedRate = 30000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        List<Station> listOfStation;
        try {
            listOfStation = getTheListOfTheStationsStatus();
            insertAvailableDocksStationCollectionMetrics(listOfStation);
            insertBikesByStationCollectionMetrics(listOfStation);
            insertUsePercentageCollectionMetrics(listOfStation);
        }catch(Exception e){
            log.error("Communication fails to BSM");
        }
    }

    private void insertAvailableDocksStationCollectionMetrics( List<Station> listOfStation) {
        List<InfluxRegisterDTO> listOfValues =
                parserToDatabase.processListOfStationsToGetNumberOfAvailableDocks(listOfStation);
        insertToDatabase.insertListOfStationsToGetNumberOfAvailableDocks(listOfValues);
    }

    private void insertBikesByStationCollectionMetrics( List<Station> stationStatus) {
        List<InfluxRegisterDTO> listOfValues =
                parserToDatabase.processListOfStationsToGetNumberOfAvailableBikes(stationStatus);
        insertToDatabase.insertListOfStationsToGetNumberOfAvailableBikes(listOfValues);
    }

    private void insertUsePercentageCollectionMetrics( List<Station> stationStatus) {
        List<InfluxRegisterDTO> listOfValues =
                parserToDatabase.processListOfStationsToGetUsePercentage(stationStatus);
        insertToDatabase.insertListOfStationsToGetUsePercentage(listOfValues);
    }

    private List<Station> getTheListOfTheStationsStatus() {
        StationStatus stationStatus = bicingApiCall.getStationStatus();
        log.info("The last update is {} and the {}", stationStatus.getLast_updated(),stationStatus.getTtl());
        return stationStatus.getData().getStations();
    }
}