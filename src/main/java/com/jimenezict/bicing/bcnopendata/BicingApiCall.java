package com.jimenezict.bicing.bcnopendata;

import com.jimenezict.bicing.bcnopendata.dto.StationStatus;
import org.springframework.stereotype.Service;

@Service
public interface BicingApiCall {

    public StationStatus getStationStatus();

}
