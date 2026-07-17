package org.example.ingekbe.measurement.api;

public interface MeasurementService {
    public MeasurementDto save(MeasurementDto dto);
    public MeasurementDto update(int id, MeasurementDto dto);
    public void delete(int id);
    public MeasurementDto get(int id);
}
