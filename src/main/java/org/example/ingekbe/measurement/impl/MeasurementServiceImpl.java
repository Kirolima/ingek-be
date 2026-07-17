package org.example.ingekbe.measurement.impl;

import org.example.ingekbe.appUser.impl.AppUser;
import org.example.ingekbe.measurement.api.MeasurementDto;
import org.example.ingekbe.measurement.api.MeasurementService;
import org.example.ingekbe.unit.api.UnitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementServiceImpl implements MeasurementService{

    @Autowired
    MeasurementRepository repository;

    public MeasurementDto save(MeasurementDto measurementDto) {
        Measurement entity = repository.save(toEntity(measurementDto));
        return toDto(entity);
    }

    public MeasurementDto update(int id, MeasurementDto measurementDto) {
        Measurement existin = find(id);
        existin.measurementId = measurementDto.measurementId;
        existin.cowId = measurementDto.cowId;
        existin.unitId = measurementDto.unitId;
        existin.measurementDate = measurementDto.measurementDate;
        existin.weight =measurementDto.weight;
        existin.legLiftDuration = measurementDto.legLiftDuration;
        existin.lwr = measurementDto.lwr;
        existin.standardDeviation = measurementDto.standardDeviation;
        existin.numberOfLegMovements = measurementDto.numberOfLegMovements;
        existin.riskScore = measurementDto.riskSccore;
        return toDto(existin);
    }

    public void delete(int id) {
        Measurement measurement = find(id);
        repository.delete(measurement);
    }

    public MeasurementDto get(int id) {return toDto(find(id));}

    public Measurement find(int id) {
        return repository.findById(id).orElse(null);
    }



    public static MeasurementDto toDto(Measurement measurement) {
        MeasurementDto dto = new MeasurementDto();
        dto.measurementId = measurement.measurementId;
        dto.cowId = measurement.cowId;
        dto.unitId = measurement.unitId;
        dto.weight = measurement.weight;
        dto.lwr = measurement.lwr;
        dto.asymmetryIndex = measurement.asymmetryIndex;
        dto.legLiftDuration = measurement.legLiftDuration;
        dto.numberOfLegMovements = measurement.numberOfLegMovements;
        dto.standardDeviation = measurement.standardDeviation;
        dto.measurementDate =measurement.measurementDate;
        dto.riskSccore = measurement.riskScore;
        return dto;
    }

    public static Measurement toEntity(MeasurementDto dto) {
        Measurement entitiy = new Measurement();
        entitiy.measurementId = dto.measurementId;
        entitiy.cowId = dto.cowId;
        entitiy.unitId = dto.unitId;
        entitiy.lwr = dto.lwr;
        entitiy.standardDeviation = dto.standardDeviation;
        entitiy.numberOfLegMovements = dto.numberOfLegMovements;
        entitiy.weight = dto.weight;
        entitiy.asymmetryIndex = dto.asymmetryIndex;
        entitiy.legLiftDuration = dto.legLiftDuration;
        entitiy.riskScore = dto.riskSccore;
        return entitiy;
    }
}
