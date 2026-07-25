package org.example.ingekbe.measurement.impl;

import jakarta.persistence.*;
import org.example.ingekbe.cow.impl.Cow;
import org.example.ingekbe.unit.impl.Unit;
import java.util.Date;


@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int measurementId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cow_id", nullable = false)
    public Cow cow;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id", nullable = false)
    public Unit unit;

    public int weight;
    public int standardDeviation;
    public int lwr;
    public int legLiftDuration;
    public int numberOfLegMovements;
    public int asymmetryIndex;
    public Date measurementDate;
    public int riskScore;

    public int getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(int measurementId) {
        this.measurementId = measurementId;
    }

    public Cow getCow() {
        return cow;
    }

    public void setCow(Cow cow) {
        this.cow = cow;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
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
