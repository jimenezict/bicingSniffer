package com.jimenezict.bicing.getstationstatus.influx;

import com.jimenezict.bicing.getstationstatus.influx.dto.InfluxRegisterDTO;
import org.influxdb.InfluxDB;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluxRegisterDAOImpl implements InfluxRegisterDAO{

    @Override
    public InfluxDB getInstance(){
        return InfluxConnectionSingletone.getInstance();
    }

    @Override
    public void insertInfluxRegisterDTOByMeasure(String measure, InfluxRegisterDTO register){
        BatchPoints batchPoints = defineBatchPolicy();

        Point point = defineNewPointWithMeasureForaInfluxRegister(measure, register);

        addRegisterToTheBatch(batchPoints, point);

        InfluxConnectionSingletone.getInstance().write(batchPoints);
    }

    @Override
    public void insertListOfInfluxRegisterDTOsByMeasure(String measure, List<InfluxRegisterDTO> registers){
        BatchPoints batchPoints = defineBatchPolicy();

        for(InfluxRegisterDTO register:registers){
            Point point = defineNewPointWithMeasureForaInfluxRegister(measure, register);
            addRegisterToTheBatch(batchPoints, point);
        }

        InfluxConnectionSingletone.getInstance().write(batchPoints);
    }

    private void addRegisterToTheBatch(BatchPoints batchPoints, Point point) {
        batchPoints.point(point);
    }

    private Point defineNewPointWithMeasureForaInfluxRegister(String measure, InfluxRegisterDTO register) {
        return Point.measurement(measure)
                .tag("station", (new Integer(register.getId())).toString())
                .addField("value", register.getValue())
                .build();
    }

    private BatchPoints defineBatchPolicy() {
        return BatchPoints
                .database("bicing")
                .retentionPolicy("defaultPolicy")
                .build();
    }

}
