package org.example.ingekbe.farm.impl;

import jakarta.persistence.*;
import org.example.ingekbe.appUser.impl.AppUser;
import org.example.ingekbe.cow.impl.Cow;
import org.example.ingekbe.unit.impl.Unit;

import java.util.List;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int farmId;

    public String farmName;
    public String location;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_id", nullable = false)
    public AppUser appUser;

    @OneToMany(mappedBy = "farm")
    public List<Cow> cows;

    @OneToMany(mappedBy = "farm")
    public List<Unit> units;

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public List<Cow> getCows() {
        return cows;
    }

    public void setCows(List<Cow> cows) {
        this.cows = cows;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }
}
