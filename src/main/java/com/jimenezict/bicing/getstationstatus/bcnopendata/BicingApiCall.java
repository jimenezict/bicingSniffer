package com.jimenezict.bicing.getstationstatus.bcnopendata;

import com.jimenezict.bicing.getstationstatus.bcnopendata.dto.StationStatus;
import org.springframework.stereotype.Service;

@Service
public interface BicingApiCall {

    public StationStatus getStationStatus();

}
