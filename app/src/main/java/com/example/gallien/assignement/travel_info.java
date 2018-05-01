package com.example.gallien.assignement;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

/**
 * Created by Gallien on 18/04/2018.
 */
public class travel_info {
    String country;
    List<String> cities= new ArrayList<>();

    public travel_info(String country, String[] cities){

        this.country=country;
        this.cities = Arrays.asList(cities);
    }

}