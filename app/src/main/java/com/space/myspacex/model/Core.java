package com.space.myspacex.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

public class Core {

    private String core_serial;
    private Integer flight;
    private Integer block;
    private Boolean reused;
    private Boolean land_success;
    private Boolean landing_intent;
    private String landing_type;
    private String landing_vehicle;

    public String getCoreSerial() {
        return core_serial;
    }

    public void setCoreSerial(String coreSerial) {
        this.core_serial = coreSerial;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public Boolean getLandSuccess() {
        return land_success;
    }

    public void setLandSuccess(Boolean landSuccess) {
        this.land_success = landSuccess;
    }

    public Boolean getLandingIntent() {
        return landing_intent;
    }

    public void setLandingIntent(Boolean landingIntent) {
        this.landing_intent = landingIntent;
    }

    public String getLandingType() {
        return landing_type;
    }

    public void setLandingType(String landingType) {
        this.landing_type = landingType;
    }

    public String getLandingVehicle() {
        return landing_vehicle;
    }

    public void setLandingVehicle(String landingVehicle) {
        this.landing_vehicle = landingVehicle;
    }

}
