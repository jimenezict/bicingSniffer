package com.jimenezict.bicing.getstationstatus.opendata;

import com.jimenezict.bicing.getstationstatus.opendata.dto.StationStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetStationsStatusImpl implements GetStationsStatus {

    private final String url = "https://api.bsmsa.eu/ext/api/bsm/gbfs/v2/en/station_status";

    public StationStatus getStationStatus(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url,StationStatus.class);
    }

}
