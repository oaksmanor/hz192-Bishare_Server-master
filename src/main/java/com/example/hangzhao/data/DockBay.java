package com.example.hangzhao.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by hangzhao on 7/10/16.
 */
public class DockBay implements Serializable{


    @Id
    private String id;

    private Double latitude;
    private Double longitude;

    @DBRef
    private List<Bicycle> bicycleSet;

    public List<Bicycle> getBicycleSet() {
        return bicycleSet;
    }

    public void setBicycleSet(List<Bicycle> bicycleSet) {
        this.bicycleSet = bicycleSet;
    }


    public DockBay(){}


    public DockBay(Double latitude,Double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
