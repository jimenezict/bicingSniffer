package com.jimenezict.bicing.getstationstatus.influx;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Pong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class InfluxConnectionSingletone {

    private static InfluxDB influxDB;
    private static Logger log = LoggerFactory.getLogger(InfluxConnectionSingletone.class);

    private String connectionString = "http://localhost:8086";
    private String database = "bicing";

    private InfluxConnectionSingletone(){
        influxDB = InfluxDBFactory.connect(connectionString);
        influxDB.createDatabase(database);
        influxDB.createRetentionPolicy("defaultPolicy", "bicing", "30d", 1, true);
        influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);
        influxDB.setDatabase(database);
    }

    public static InfluxDB getInstance(){
        if(influxDB == null){
            log.info("Created a new Connection Singlentone");
            new InfluxConnectionSingletone();
        }
        testConnection();
        return influxDB;
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
