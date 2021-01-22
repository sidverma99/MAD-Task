package com.example.madtask;

import com.google.gson.annotations.SerializedName;

public class suggestion {

    @SerializedName("latitude")
    private Double latitude;
    @SerializedName("longitude")
    private Double longitude;


    public suggestion() {
    }

    public suggestion(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
