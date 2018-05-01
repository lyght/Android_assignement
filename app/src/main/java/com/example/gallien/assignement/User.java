package com.example.gallien.assignement;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gallien on 17/04/2018.
 */

public class User {


    private String country;

    private List<String> cities = new ArrayList<>();

    public User( String country, List<String> cities) {

        this.cities = cities;

        this.country=country;
    }


    public List<String> getCities() {

        return cities;
    }


    public String getCountry() {

        return country;
    }


}