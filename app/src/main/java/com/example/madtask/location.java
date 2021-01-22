package com.example.madtask;

import com.google.gson.annotations.SerializedName;

public class location {
    @SerializedName("address")
    private String address;
    @SerializedName("locality")
    private String locality;
    @SerializedName("city")
    private String city;

    public location() {
    }

    public location(String address, String locality, String city) {
        this.address = address;
        this.locality = locality;
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public String getLocality() {
        return locality;
    }

    public String getCity() {
        return city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
