package org.example.ingekbe.farm.web;

public class FarmRequest {

    public int farmId;
    public int appUserId;
    public String farmName;
    public int numberOfUnits;
    public String location;
    public int cowOfNumber;

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCowOfNumber() {
        return cowOfNumber;
    }

    public void setCowOfNumber(int cowOfNumber) {
        this.cowOfNumber = cowOfNumber;
    }
}
