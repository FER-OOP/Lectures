/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.homework_13.e01;

import java.util.Objects;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class PollingStation {

    //county and place
    private int countyId;
    private String county;
    private String label;
    private String place;
    //polling station
    private int id;
    private String title;
    private String location;
    private String address;

    public PollingStation(int countyId, String county, String label, String place, int id, String title, String location, String address) {
        this.countyId = countyId;
        this.county = county;
        this.label = label;
        this.place = place;
        this.id = id;
        this.title = title;
        this.location = location;
        this.address = address;
    }

    public int getCountyId() {
        return countyId;
    }

    public String getCounty() {
        return county;
    }

    public String getLabel() {
        return label;
    }

    public String getPlace() {
        return place;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.countyId, this.place, this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PollingStation other = (PollingStation) obj;
        if (this.countyId != other.countyId) {
            return false;
        }
        if (!Objects.equals(this.place, other.place)) {
            return false;
        }
        return this.id == other.id;
    }      
}
