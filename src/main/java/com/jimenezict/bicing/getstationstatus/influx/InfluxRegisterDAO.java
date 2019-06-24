package com.jimenezict.bicing.getstationstatus.influx;

import com.jimenezict.bicing.getstationstatus.influx.dto.InfluxRegisterDTO;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InfluxRegisterDAO {

    public InfluxDB getInstance();

    public void insertInfluxRegisterDTOByMeasure(String measure, InfluxRegisterDTO register);

    public void insertListOfInfluxRegisterDTOsByMeasure(String measure, List<InfluxRegisterDTO> register);

}
