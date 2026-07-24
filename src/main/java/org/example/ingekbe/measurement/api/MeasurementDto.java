package org.example.ingekbe.measurement.api;

import java.util.Date;

public class MeasurementDto {

    public int measurementId;
    public int weight;
    public int standardDeviation;
    public int lwr;
    public int legLiftDuration;
    public int numberOfLegMovements;
    public int asymmetryIndex;
    public Date measurementDate;
    public int riskScore;
    public int cowId;
    public int unitId;

    public int getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(int measurementId) {
        this.measurementId = measurementId;
    }

    public int getCowId() {
        return cowId;
    }

    public void setCowId(int cowId) {
        this.cowId = cowId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(int standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public int getLwr() {
        return lwr;
    }

    public void setLwr(int lwr) {
        this.lwr = lwr;
    }

    public int getLegLiftDuration() {
        return legLiftDuration;
    }

    public void setLegLiftDuration(int legLiftDuration) {
        this.legLiftDuration = legLiftDuration;
    }

    public int getNumberOfLegMovements() {
        return numberOfLegMovements;
    }

    public void setNumberOfLegMovements(int numberOfLegMovements) {
        this.numberOfLegMovements = numberOfLegMovements;
    }

    public int getAsymmetryIndex() {
        return asymmetryIndex;
    }

    public void setAsymmetryIndex(int asymmetryIndex) {
        this.asymmetryIndex = asymmetryIndex;
    }

    public Date getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(Date measurementDate) {
        this.measurementDate = measurementDate;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }
}

