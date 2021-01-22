package com.example.madtask;

import com.google.gson.annotations.SerializedName;

public class Restaurant {
    @SerializedName("name")
    private String name;
    @SerializedName("location")
    private location location;

    public Restaurant() {
    }

    public Restaurant(String name, com.example.madtask.location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public com.example.madtask.location getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(com.example.madtask.location location) {
        this.location = location;
    }
}
