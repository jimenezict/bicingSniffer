package com.jimenezict.bicing.getstationstatus.influx;

public class InfluxRegister {

    private int id;
    private double value;

    public InfluxRegister(int id, double value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
