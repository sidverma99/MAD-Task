package com.example.madtask;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestaurantResponse {
    @SerializedName("results_found")
    private int results_found;
    @SerializedName("results_shown")
    private int results_shown;
    @SerializedName("restaurants")
    private List<RestaurantDetails> restaurants;

    public RestaurantResponse() {
    }

    public RestaurantResponse(int results_found, int results_shown, List<RestaurantDetails> restaurants) {
        this.results_found = results_found;
        this.results_shown = results_shown;
        this.restaurants = restaurants;
    }

    public int getResults_found() {
        return results_found;
    }

    public int getResults_shown() {
        return results_shown;
    }

    public List<RestaurantDetails> getRestaurants() {
        return restaurants;
    }

    public void setResults_found(int results_found) {
        this.results_found = results_found;
    }

    public void setResults_shown(int results_shown) {
        this.results_shown = results_shown;
    }

    public void setRestaurants(List<RestaurantDetails> restaurants) {
        this.restaurants = restaurants;
    }
}
