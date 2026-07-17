package org.example.ingekbe.measurement.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;


@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int measurementId;
    public int cowId;
    public int unitId;
    public int weight;
    public int standardDeviation;
    public int lwr;
    public int legLiftDuration;
    public int numberOfLegMovements;
    public int asymmetryIndex;
    public Date measurementDate;
}
