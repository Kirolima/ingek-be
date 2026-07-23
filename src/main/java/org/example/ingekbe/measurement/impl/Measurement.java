package org.example.ingekbe.measurement.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.ingekbe.cow.impl.Cow;
import org.example.ingekbe.unit.impl.Unit;
import java.util.Date;


@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int measurementId;

    @ManyToOne
    @JoinColumn(name = "cow_id", nullable = false)
    public Cow cow;

    @ManyToOne
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
}
