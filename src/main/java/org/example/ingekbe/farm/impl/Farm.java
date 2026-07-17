package org.example.ingekbe.farm.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int farmId;
    public int appUserId;
    public String farmName;
    public int numberOfUnits;
    public String location;
    public int cowOfNumber;

}
