package com.jimenezict.bicing.getstationstatus.bcnopendata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StationStatus {

    private long last_updated;
    private int ttl;
    private Stations data;

    public StationStatus(){

    }

    public long getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(long last_updated) {
        this.last_updated = last_updated;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public Stations getData() {
        return data;
    }

    public void setData(Stations data) {
        this.data = data;
    }
}
