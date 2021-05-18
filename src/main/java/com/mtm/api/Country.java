package com.mtm.api;

public class Country {

    private String country;
    private String name;
    private String lat;
    private String lng;

    public Country() {
        this.country = "null";
        this.name = "null";
        this.lat = "null";
        this.lng = "null";
    }

    public Country(String country, String name, String lat, String lng) {
        this.country = country;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlat() {
        return lat;
    }

    public void setlat(String lat) {
        this.lat = lat;
    }

    public String getIng() {
        return lng;
    }

    public void setIng(String lng) {
        this.lng = lng;
    }

}
