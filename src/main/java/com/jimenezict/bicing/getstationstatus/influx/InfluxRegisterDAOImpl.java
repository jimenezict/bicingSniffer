package com.jimenezict.bicing.getstationstatus.influx;

public class InfluxRegisterDAOImpl implements InfluxRegisterDAO{

    @Override
    public InfluxConnectionSingletone getInstance(){
        return InfluxConnectionSingletone.getInstance();
    }

}
