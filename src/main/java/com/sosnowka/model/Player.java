package com.sosnowka.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Pawel on 16.11.2017.
 */
@Entity
public class Player {
    @ManyToMany(mappedBy = "players")
    @JsonIgnore
    private List<Booking> bookingList;

    @ManyToMany
    @JsonIgnoreProperties("setOfUser")
    private Set<Team> userTeams;

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String firstName;
    private String lastName;
    @Column(unique = true)
    @NotNull
    private String username;
    //yyyy-mm-DD
    private String birthDate;
    @Column(columnDefinition = "TEXT")
    private String image;

    public Player() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public Set<Team> getUserTeams() {
        return userTeams;
    }

    public void setUserTeams(Set<Team> userTeams) {
        this.userTeams = userTeams;
    }
}
