package org.example.ingekbe.cow.impl;


import jakarta.persistence.*;
import org.example.ingekbe.farm.impl.Farm;
import org.example.ingekbe.measurement.impl.Measurement;

import java.util.List;

@Entity
public class Cow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int cowId;

    public String earTagNumber;
    public int age;
    public String cowBreed;

    @OneToMany(mappedBy = "cow")
    public List<Measurement> measurements;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id", nullable = false)
    public Farm farm;


    public int getCowId() {
        return cowId;
    }

    public void setCowId(int cowId) {
        this.cowId = cowId;
    }

    public String getEarTagNumber() {
        return earTagNumber;
    }

    public void setEarTagNumber(String earTagNumber) {
        this.earTagNumber = earTagNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCowBreed() {
        return cowBreed;
    }

    public void setCowBreed(String cowBreed) {
        this.cowBreed = cowBreed;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}
