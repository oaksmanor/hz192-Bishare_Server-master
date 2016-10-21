package com.example.hangzhao.data;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by hangzhao on 7/10/16.
 */
public class Bicycle implements Serializable {


    @Id
    private String id;

    private boolean isAvailable;

    private DockBay dockBay;

    public DockBay getDockBay() {
        return dockBay;
    }

    public void setDockBay(DockBay dockBay) {
        this.dockBay = dockBay;
    }

    public Bicycle(){}

    public Bicycle(boolean isAvailable){this.isAvailable = isAvailable;}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "id='" + id + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
