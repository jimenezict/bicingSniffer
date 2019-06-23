package com.jimenezict.bicing.getstationstatus.influx;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Pong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class InfluxConnectionSingletone {

    private static InfluxConnectionSingletone influxConnection;
    private static InfluxDB influxDB;
    private static Logger log = LoggerFactory.getLogger(InfluxConnectionSingletone.class);

    private String connectionString = "http://localhost:8086";

    private InfluxConnectionSingletone(){
        influxDB = InfluxDBFactory.connect(connectionString);
    }

    public static InfluxConnectionSingletone getInstance(){
        if(influxConnection == null){
            log.info("Created a new Connection Singlentone");
            influxConnection = new InfluxConnectionSingletone();
        }
        testConnection();
        return influxConnection;
    }

    private static void testConnection(){
        Pong response = influxDB.ping();
        if ((response.getVersion().equalsIgnoreCase("unknown"))) {
            log.error("Error pinging server.");
        } else {
            log.info("OK pinging server");
        }
    }
}
