package com.space.myspacex.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

public class Rocket {

    private String rocket_id;
    private String rocket_name;
    private String rocket_type;
    private FirstStage first_stage;
    private SecondStage second_stage;
    private Fairings fairings;

    public String getRocketId() {
        return rocket_id;
    }

    public void setRocketId(String rocketId) {
        this.rocket_id = rocketId;
    }

    public String getRocketName() {
        return rocket_name;
    }

    public void setRocketName(String rocketName) {
        this.rocket_name = rocketName;
    }

    public String getRocketType() {
        return rocket_type;
    }

    public void setRocketType(String rocketType) {
        this.rocket_type = rocketType;
    }

    public FirstStage getFirstStage() {
        return first_stage;
    }

    public void setFirstStage(FirstStage firstStage) {
        this.first_stage = firstStage;
    }

    public SecondStage getSecondStage() {
        return second_stage;
    }

    public void setSecondStage(SecondStage secondStage) {
        this.second_stage = secondStage;
    }

    public Fairings getFairings() {
        return fairings;
    }

    public void setFairings(Fairings fairings) {
        this.fairings = fairings;
    }

}
