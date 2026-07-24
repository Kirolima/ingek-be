package org.example.ingekbe.unit.web;

import org.example.ingekbe.measurement.api.MeasurementDto;
import org.example.ingekbe.measurement.impl.Measurement;
import org.example.ingekbe.measurement.web.MeasurementResponse;

import java.util.Date;
import java.util.List;

public class UnitResponse {
    public int unitId;
    public int farmId;
    public String unitName;
    public Date installationDate;

    public List<MeasurementResponse> measurements;

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
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

    public List<MeasurementResponse> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<MeasurementResponse> measurements) {
        this.measurements = measurements;
    }
}
