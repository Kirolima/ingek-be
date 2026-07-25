package org.example.ingekbe.unit.impl;

import jakarta.persistence.*;
import org.example.ingekbe.farm.impl.Farm;
import org.example.ingekbe.measurement.impl.Measurement;

import java.util.Date;
import java.util.List;

@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int unitId;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id", nullable = false)
    public Farm farm;

    public String unitName;
    public Date installationDate;

    @OneToMany(mappedBy = "unit")
    public List<Measurement> measurements;

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Date getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {
        this.installationDate = installationDate;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }
}
