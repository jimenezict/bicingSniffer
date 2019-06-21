package com.jimenezict.bicing.getstationstatus;

import com.jimenezict.bicing.getstationstatus.dto.StationStatus;
import org.springframework.stereotype.Service;

@Service
public interface GetStationsStatus {

    public StationStatus getStationStatus();

}
