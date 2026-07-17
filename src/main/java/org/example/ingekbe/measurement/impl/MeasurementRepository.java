package org.example.ingekbe.measurement.impl;

import org.example.ingekbe.measurement.impl.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
