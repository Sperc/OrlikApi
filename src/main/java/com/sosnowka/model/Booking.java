package com.sosnowka.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private List<Player> players;

    @Id
    @GeneratedValue
    private Long id;
    //yyyy-MM-dd
    private String date;
    private String endDate;
    private int startOrderHour;
    private int startOrderMinutes;
    private int endOrderHour;
    private int endOrderMinutes;
    private int maxNumberOfPlayer = 14;
    private boolean isAvailable = true;
    private String leaderName;

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStartOrderHour() {
        return startOrderHour;
    }

    public void setStartOrderHour(int startOrderHour) {
        this.startOrderHour = startOrderHour;
    }

    public int getStartOrderMinutes() {
        return startOrderMinutes;
    }

    public void setStartOrderMinutes(int startOrderMinutes) {
        this.startOrderMinutes = startOrderMinutes;
    }

    public int getEndOrderHour() {
        return endOrderHour;
    }

    public void setEndOrderHour(int endOrderHour) {
        this.endOrderHour = endOrderHour;
    }

    public int getEndOrderMinutes() {
        return endOrderMinutes;
    }

    public void setEndOrderMinutes(int endOrderMinutes) {
        this.endOrderMinutes = endOrderMinutes;
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

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}