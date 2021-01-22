package com.example.madtask;

import com.google.gson.annotations.SerializedName;

public class RestaurantDetails {
    @SerializedName("restaurant")
    private Restaurant mRestaurant;

    public RestaurantDetails() {
    }

    public RestaurantDetails(Restaurant restaurant) {
        mRestaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return mRestaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        mRestaurant = restaurant;
    }
}
