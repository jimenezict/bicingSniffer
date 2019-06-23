package com.jimenezict.bicing.getstationstatus.opendata;

import com.jimenezict.bicing.getstationstatus.opendata.dto.StationStatus;
import org.springframework.stereotype.Service;

@Service
public interface GetStationsStatus {

    public StationStatus getStationStatus();

}
