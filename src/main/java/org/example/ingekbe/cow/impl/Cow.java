package org.example.ingekbe.cow.impl;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.ingekbe.farm.impl.Farm;

@Entity
public class Cow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int cowId;

    @ManyToOne
    @JoinColumn(name = "farm_id", nullable = false)
    public Farm farm;

    public String earTagNumber;
    public int age;
    public String cowBreed;

}
