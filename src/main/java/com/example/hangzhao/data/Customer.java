package com.example.hangzhao.data;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hangzhao on 7/10/16.
 */
public class Customer implements Serializable {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    private Bicycle kept_bicycle;


    private Date rentTime;



    public Date getRentTime() {
        return rentTime;
    }

    public void setRentTime(Date rentTime) {
        this.rentTime = rentTime;
    }




    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Bicycle getKept_bicycle() {
        return kept_bicycle;
    }

    public void setKept_bicycle(Bicycle kept_bicycle) {
        this.kept_bicycle = kept_bicycle;
    }

    public Customer(String firstName, String lastName, Bicycle kept_bicycle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.kept_bicycle = kept_bicycle;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s, firstName='%s', lastName='%s']", id,
                firstName, lastName);
    }
}
