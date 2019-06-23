package com.jimenezict.bicing.getstationstatus.influx;

import com.jimenezict.bicing.getstationstatus.influx.dto.InfluxRegisterDTO;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;

public interface InfluxRegisterDAO {

    public InfluxDB getInstance();

    public void insertInfluxRegisterDTOByMeasure(String measure, InfluxRegisterDTO register);

}
