package com.space.myspacex.model;

public class Fairings {

    private Boolean reused;
    private Boolean recovery_attempt;
    private Boolean recovered;
    private Object ship;

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public Boolean getRecoveryAttempt() {
        return recovery_attempt;
    }

    public void setRecoveryAttempt(Boolean recoveryAttempt) {
        this.recovery_attempt = recoveryAttempt;
    }

    public Boolean getRecovered() {
        return recovered;
    }

    public void setRecovered(Boolean recovered) {
        this.recovered = recovered;
    }

    public Object getShip() {
        return ship;
    }

    public void setShip(Object ship) {
        this.ship = ship;
    }

}
