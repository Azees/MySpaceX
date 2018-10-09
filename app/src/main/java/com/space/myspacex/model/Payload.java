package com.space.myspacex.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Payload {

    private String payload_id;
    private List<Integer> norad_id = null;
    private Boolean reused;
    private List<String> customers = null;
    private String nationality;
    private String manufacturer;
    private String payload_type;
    private Integer payload_mass_kg;
    private Float payload_mass_lbs;
    private String orbit;
    private OrbitParams orbit_params;


    public String getPayloadId() {
        return payload_id;
    }

    public void setPayloadId(String payloadId) {
        this.payload_id = payloadId;
    }

    public List<Integer> getNoradId() {
        return norad_id;
    }

    public void setNoradId(List<Integer> noradId) {
        this.norad_id = noradId;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPayloadType() {
        return payload_type;
    }

    public void setPayloadType(String payloadType) {
        this.payload_type = payloadType;
    }

    public Integer getPayloadMassKg() {
        return payload_mass_kg;
    }

    public void setPayloadMassKg(Integer payloadMassKg) {
        this.payload_mass_kg = payloadMassKg;
    }

    public Float getPayloadMassLbs() {
        return payload_mass_lbs;
    }

    public void setPayloadMassLbs(Float payloadMassLbs) {
        this.payload_mass_lbs = payloadMassLbs;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public OrbitParams getOrbitParams() {
        return orbit_params;
    }

    public void setOrbitParams(OrbitParams orbitParams) {
        this.orbit_params = orbitParams;
    }

}
