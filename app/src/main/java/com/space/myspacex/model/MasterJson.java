package com.space.myspacex.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class MasterJson implements Parcelable {

    private Integer flight_number;
    private String mission_name;
    private List<String> mission_id;
    private String launch_year;
    private Integer launch_date_unix;
    private String launch_date_utc;
    private String launch_date_local;
    private Boolean is_tentative;
    private String tentative_max_precision;
    private Rocket rocket;
    private List<String> ships;
    private Telemetry telemetry;
    private LaunchSite launch_site;
    private Boolean launch_success;
    private Links links;
    private String details;
    private Boolean upcoming;
    private String static_fire_date_utc;
    private Integer static_fire_date_unix;

    protected MasterJson(Parcel in) {
        if (in.readByte() == 0) {
            flight_number = null;
        } else {
            flight_number = in.readInt();
        }
        mission_name = in.readString();
        mission_id = in.createStringArrayList();
        launch_year = in.readString();
        if (in.readByte() == 0) {
            launch_date_unix = null;
        } else {
            launch_date_unix = in.readInt();
        }
        launch_date_utc = in.readString();
        launch_date_local = in.readString();
        byte tmpIs_tentative = in.readByte();
        is_tentative = tmpIs_tentative == 0 ? null : tmpIs_tentative == 1;
        tentative_max_precision = in.readString();
        ships = in.createStringArrayList();
        byte tmpLaunch_success = in.readByte();
        launch_success = tmpLaunch_success == 0 ? null : tmpLaunch_success == 1;
        details = in.readString();
        byte tmpUpcoming = in.readByte();
        upcoming = tmpUpcoming == 0 ? null : tmpUpcoming == 1;
        static_fire_date_utc = in.readString();
        if (in.readByte() == 0) {
            static_fire_date_unix = null;
        } else {
            static_fire_date_unix = in.readInt();
        }
    }

    public static final Creator<MasterJson> CREATOR = new Creator<MasterJson>() {
        @Override
        public MasterJson createFromParcel(Parcel in) {
            return new MasterJson(in);
        }

        @Override
        public MasterJson[] newArray(int size) {
            return new MasterJson[size];
        }
    };

    public Integer getFlightNumber() {
        return flight_number;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flight_number = flightNumber;
    }

    public String getMissionName() {
        return mission_name;
    }

    public void setMissionName(String missionName) {
        this.mission_name = missionName;
    }

    public List<String> getMissionId() {
        return mission_id;
    }

    public void setMissionId(List<String> missionId) {
        this.mission_id = missionId;
    }

    public String getLaunchYear() {
        return launch_year;
    }

    public void setLaunchYear(String launchYear) {
        this.launch_year = launchYear;
    }

    public Integer getLaunchDateUnix() {
        return launch_date_unix;
    }

    public void setLaunchDateUnix(Integer launchDateUnix) {
        this.launch_date_unix = launchDateUnix;
    }

    public String getLaunchDateUtc() {
        return launch_date_utc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launch_date_utc = launchDateUtc;
    }

    public String getLaunchDateLocal() {
        return launch_date_local;
    }

    public void setLaunchDateLocal(String launchDateLocal) {
        this.launch_date_local = launchDateLocal;
    }

    public Boolean getIsTentative() {
        return is_tentative;
    }

    public void setIsTentative(Boolean isTentative) {
        this.is_tentative = isTentative;
    }

    public String getTentativeMaxPrecision() {
        return tentative_max_precision;
    }

    public void setTentativeMaxPrecision(String tentativeMaxPrecision) {
        this.tentative_max_precision = tentativeMaxPrecision;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public List<String> getShips() {
        return ships;
    }

    public void setShips(List<String> ships) {
        this.ships = ships;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public LaunchSite getLaunchSite() {
        return launch_site;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launch_site = launchSite;
    }

    public Boolean getLaunchSuccess() {
        return launch_success;
    }

    public void setLaunchSuccess(Boolean launchSuccess) {
        this.launch_success = launchSuccess;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        this.upcoming = upcoming;
    }

    public String getStaticFireDateUtc() {
        return static_fire_date_utc;
    }

    public void setStaticFireDateUtc(String staticFireDateUtc) {
        this.static_fire_date_utc = staticFireDateUtc;
    }

    public Integer getStaticFireDateUnix() {
        return static_fire_date_unix;
    }

    public void setStaticFireDateUnix(Integer staticFireDateUnix) {
        this.static_fire_date_unix = staticFireDateUnix;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (flight_number == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(flight_number);
        }
        dest.writeString(mission_name);
        dest.writeStringList(mission_id);
        dest.writeString(launch_year);
        if (launch_date_unix == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(launch_date_unix);
        }
        dest.writeString(launch_date_utc);
        dest.writeString(launch_date_local);
        dest.writeByte((byte) (is_tentative == null ? 0 : is_tentative ? 1 : 2));
        dest.writeString(tentative_max_precision);
        dest.writeStringList(ships);
        dest.writeByte((byte) (launch_success == null ? 0 : launch_success ? 1 : 2));
        dest.writeString(details);
        dest.writeByte((byte) (upcoming == null ? 0 : upcoming ? 1 : 2));
        dest.writeString(static_fire_date_utc);
        if (static_fire_date_unix == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(static_fire_date_unix);
        }
    }
}
