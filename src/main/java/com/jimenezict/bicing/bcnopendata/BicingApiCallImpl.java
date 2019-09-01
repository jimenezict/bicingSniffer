package com.jimenezict.bicing.bcnopendata;

import com.jimenezict.bicing.bcnopendata.dto.StationStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BicingApiCallImpl implements BicingApiCall {

    private final String url = "https://api.bsmsa.eu/ext/api/bsm/gbfs/v2/en/station_status";

    public StationStatus getStationStatus(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url,StationStatus.class);
    }

}
