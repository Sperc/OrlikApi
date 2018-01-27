package com.sosnowka.model.wraper;

/**
 * Created by Pawel on 16.01.2018.
 */
public class Time {
    private int hour;
    private int time;
    private String date;

    public Time(int hour, int time, String date) {
        this.hour = hour;
        this.time = time;
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
