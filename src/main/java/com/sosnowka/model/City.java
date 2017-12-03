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
    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Playground> playgroundList;

    public City() {
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
