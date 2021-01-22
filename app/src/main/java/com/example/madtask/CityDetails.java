package com.example.madtask;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityDetails {

    @SerializedName("location_suggestions")
    private List<suggestion> suggestionList;
    @SerializedName("status")
    private String status;
    @SerializedName("has_more")
    private int has_more;
    @SerializedName("has_total")
    private int has_total;
    @SerializedName("user_has_addresses")
    private Boolean user_has_addresses;

    public CityDetails(List<suggestion> suggestionList, String status, int has_more, int has_total, Boolean user_has_addresses) {
        this.suggestionList = suggestionList;
        this.status = status;
        this.has_more = has_more;
        this.has_total = has_total;
        this.user_has_addresses = user_has_addresses;
    }

    public List<suggestion> getSuggestionList() {
        return suggestionList;
    }

    public String getStatus() {
        return status;
    }

    public int getHas_more() {
        return has_more;
    }

    public int getHas_total() {
        return has_total;
    }

    public Boolean getUser_has_addresses() {
        return user_has_addresses;
    }

    public void setSuggestionList(List<suggestion> suggestionList) {
        this.suggestionList = suggestionList;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHas_more(int has_more) {
        this.has_more = has_more;
    }

    public void setHas_total(int has_total) {
        this.has_total = has_total;
    }

    public void setUser_has_addresses(Boolean user_has_addresses) {
        this.user_has_addresses = user_has_addresses;
    }
}
