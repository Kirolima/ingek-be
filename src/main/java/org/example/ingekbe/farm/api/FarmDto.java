package org.example.ingekbe.farm.api;

import org.example.ingekbe.cow.api.CowDto;
import org.example.ingekbe.unit.api.UnitDto;


import java.util.List;

public class FarmDto {

    public int farmId;
    public String farmName;
    public String location;
    public int appUserId;

    public List<CowDto> cows;

    public List<UnitDto> units;

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public List<CowDto> getCows() {
        return cows;
    }

    public void setCows(List<CowDto> cows) {
        this.cows = cows;
    }

    public List<UnitDto> getUnits() {
        return units;
    }

    public void setUnits(List<UnitDto> units) {
        this.units = units;
    }
}
