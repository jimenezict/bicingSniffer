package com.jimenezict.bicing.scheduler;

import com.jimenezict.bicing.getstationstatus.opendata.GetStationsStatus;
import com.jimenezict.bicing.getstationstatus.opendata.dto.StationStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RealTimeStationBicing {

    private static final Logger log = LoggerFactory.getLogger(RealTimeStationBicing.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private GetStationsStatus getStationsStatus;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        StationStatus stationStatus= getTheOccupacyOfTheStations();
        generateAvailableStationCollection(stationStatus);
        generateBikesByStationCollection(stationStatus);
        generateUsePercentageCollection(stationStatus);
    }

    private void generateUsePercentageCollection(StationStatus stationStatus) {
    }

    private void generateBikesByStationCollection(StationStatus stationStatus) {
    }

    private void generateAvailableStationCollection(StationStatus stationStatus) {
    }

    private StationStatus getTheOccupacyOfTheStations() {
        StationStatus stationStatus = getStationsStatus.getStationStatus();
        log.info("The last update is {} and the {}", stationStatus.getLast_updated(),stationStatus.getTtl());
        return stationStatus;
    }
}