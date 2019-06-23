package com.jimenezict.bicing.getstationstatus.influx;

import com.jimenezict.bicing.getstationstatus.influx.dto.InfluxRegisterDTO;
import org.influxdb.InfluxDB;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;

import java.util.concurrent.TimeUnit;

public class InfluxRegisterDAOImpl implements InfluxRegisterDAO{

    @Override
    public InfluxDB getInstance(){
        return InfluxConnectionSingletone.getInstance();
    }

    @Override
    public void insertInfluxRegisterDTOByMeasure(String measure, InfluxRegisterDTO register){
        BatchPoints batchPoints = defineBatchPolicy();

        Point point = Point.measurement(measure)
                .tag("station",(new Integer(register.getId())).toString())
                .addField("value",register.getValue())
                .build();

        batchPoints.point(point);

        InfluxConnectionSingletone.getInstance().write(batchPoints);
    }

    private BatchPoints defineBatchPolicy() {
        return BatchPoints
                .database("bicing")
                .retentionPolicy("defaultPolicy")
                .build();
    }

}
