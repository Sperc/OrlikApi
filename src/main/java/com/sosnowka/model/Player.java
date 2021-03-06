package com.sosnowka.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    private Picture picture;

    public Player() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
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
