package org.example.ingekbe.cow.impl;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int cowId;
    public int farmId;
    public String earTagNumber;
    public int age;
    public String cowBreed;

}
