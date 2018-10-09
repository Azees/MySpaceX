package com.space.myspacex.model;

public class OrbitParams {

    private String reference_system;
    private String regime;
    private Integer longitude;
    private Float semi_major_axis_km;
    private Float eccentricity;
    private Float periapsis_km;
    private Float apoapsis_km;
    private Float inclination_deg;
    private Float period_min;
    private Integer lifespan_years;
    private String epoch;
    private Float mean_motion;
    private Float raan;
    private Float arg_of_pericenter;
    private Float mean_anomaly;

    public String getReferenceSystem() {
        return reference_system;
    }

    public void setReferenceSystem(String referenceSystem) {
        this.reference_system = referenceSystem;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Float getSemiMajorAxisKm() {
        return semi_major_axis_km;
    }

    public void setSemiMajorAxisKm(Float semiMajorAxisKm) {
        this.semi_major_axis_km = semiMajorAxisKm;
    }

    public Float getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Float eccentricity) {
        this.eccentricity = eccentricity;
    }

    public Float getPeriapsisKm() {
        return periapsis_km;
    }

    public void setPeriapsisKm(Float periapsisKm) {
        this.periapsis_km = periapsisKm;
    }

    public Float getApoapsisKm() {
        return apoapsis_km;
    }

    public void setApoapsisKm(Float apoapsisKm) {
        this.apoapsis_km = apoapsisKm;
    }

    public Float getInclinationDeg() {
        return inclination_deg;
    }

    public void setInclinationDeg(Float inclinationDeg) {
        this.inclination_deg = inclinationDeg;
    }

    public Float getPeriodMin() {
        return period_min;
    }

    public void setPeriodMin(Float periodMin) {
        this.period_min = periodMin;
    }

    public Integer getLifespanYears() {
        return lifespan_years;
    }

    public void setLifespanYears(Integer lifespanYears) {
        this.lifespan_years = lifespanYears;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public Float getMeanMotion() {
        return mean_motion;
    }

    public void setMeanMotion(Float meanMotion) {
        this.mean_motion = meanMotion;
    }

    public Float getRaan() {
        return raan;
    }

    public void setRaan(Float raan) {
        this.raan = raan;
    }

    public Float getArgOfPericenter() {
        return arg_of_pericenter;
    }

    public void setArgOfPericenter(Float argOfPericenter) {
        this.arg_of_pericenter = argOfPericenter;
    }

    public Float getMeanAnomaly() {
        return mean_anomaly;
    }

    public void setMeanAnomaly(Float meanAnomaly) {
        this.mean_anomaly = meanAnomaly;
    }


}
