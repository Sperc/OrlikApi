package com.sosnowka.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Pawel on 01.12.2017.
 */
@Entity
public class City {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Playground> playgroundList;

    public City() {
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Playground> getPlaygroundList() {
        return playgroundList;
    }

    public void setPlaygroundList(List<Playground> playgroundList) {
        this.playgroundList = playgroundList;
    }
}
