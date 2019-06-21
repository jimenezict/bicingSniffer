package com.jimenezict.bicing.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jimenezict.bicing.getstationstatus.GetStationsStatus;
import com.jimenezict.bicing.getstationstatus.dto.StationStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
    }

    private StationStatus getTheOccupacyOfTheStations() {
        StationStatus stationStatus = getStationsStatus.getStationStatus();
        log.info("The last update is {} and the {}", stationStatus.getLast_updated(),stationStatus.getTtl());
        return stationStatus;
    }
}