package org.example.ingekbe.farm.web;

import org.example.ingekbe.cow.api.CowDto;
import org.example.ingekbe.cow.impl.Cow;
import org.example.ingekbe.cow.web.CowResponse;
import org.example.ingekbe.unit.api.UnitDto;
import org.example.ingekbe.unit.impl.Unit;
import org.example.ingekbe.unit.web.UnitResponse;

import java.util.List;

public class FarmResponse {

    public int farmId;
    public int appUserId;
    public String farmName;
    public String location;

    public List<CowResponse> cows;
    public List<UnitResponse> units;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<CowResponse> getCows() {
        return cows;
    }

    public void setCows(List<CowResponse> cows) {
        this.cows = cows;
    }

    public List<UnitResponse> getUnits() {
        return units;
    }

    public void setUnits(List<UnitResponse> units) {
        this.units = units;
    }
}
