package org.example.ingekbe.unit.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.ingekbe.farm.impl.Farm;
import java.util.Date;

@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int unitId;

    @ManyToOne
    @JoinColumn(name = "farm_id", nullable = false)
    public Farm farm;

    public String unitName;
    public Date installationDate;
}
