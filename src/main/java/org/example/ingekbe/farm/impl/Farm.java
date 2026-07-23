package org.example.ingekbe.farm.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.ingekbe.appUser.impl.AppUser;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int farmId;

    @ManyToOne
    @JoinColumn(name = "app_user_id", nullable = false)
    public AppUser appUser;

    public String farmName;
    public int numberOfUnits;
    public String location;
    public int cowOfNumber;

}
