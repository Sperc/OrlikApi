package com.sosnowka.test;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by Pawel on 29.10.2017.
 */
@JsonRootName("myObject")
public class MyObject {
    private String name;

    public MyObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
