package com.sosnowka.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Pawel on 14.10.2017.
 */
@Entity
public class Booking {
    @ManyToOne
    @JoinColumn(name = "playground")
    @JsonIgnoreProperties("bookingSet")
    private Playground playground;

    @ManyToMany
    @JsonIgnoreProperties("usersBookingSet")
    private Set<AppUser> appUserSet;

    @Id
    @GeneratedValue
    private Long id;
    //yyyy-MM-dd
    private String date;
    private double startOrder;
    private double endOrder;
    private int maxNumberOfPlayer = 14;
    private boolean isAvailable = true;
    private Long leaderId;

    public Booking(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getStartOrder() {
        return startOrder;
    }

    public void setStartOrder(double startOrder) {
        this.startOrder = startOrder;
    }

    public double getEndOrder() {
        return endOrder;
    }

    public void setEndOrder(double endOrder) {
        this.endOrder = endOrder;
    }

    public int getMaxNumberOfPlayer() {
        return maxNumberOfPlayer;
    }

    public void setMaxNumberOfPlayer(int maxNumberOfPlayer) {
        this.maxNumberOfPlayer = maxNumberOfPlayer;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Playground getPlayground() {
        return playground;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public Set<AppUser> getAppUserSet() {
        return appUserSet;
    }

    public void setAppUserSet(Set<AppUser> appUserSet) {
        this.appUserSet = appUserSet;
    }
}
