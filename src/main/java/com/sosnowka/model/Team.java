package com.sosnowka.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Pawel on 27.10.2017.
 */
@Entity
public class Team {
    @ManyToMany(mappedBy = "userTeams")
    @JsonIgnoreProperties("userTeams")
    private Set<Player> setOfUsers;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private Long leaderId;
    private boolean isAvaiable;

    public Team() {
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

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public boolean isAvaiable() {
        return isAvaiable;
    }

    public void setAvaiable(boolean avaiable) {
        isAvaiable = avaiable;
    }

    public Set<Player> getSetOfUsers() {
        return setOfUsers;
    }

    public void setSetOfUsers(Set<Player> setOfUsers) {
        this.setOfUsers = setOfUsers;
    }
}
