package org.example.ingekbe.measurement.impl;

import org.example.ingekbe.cow.impl.Cow;
import org.example.ingekbe.cow.impl.CowRepository;
import org.example.ingekbe.measurement.api.MeasurementDto;
import org.example.ingekbe.measurement.api.MeasurementService;
import org.example.ingekbe.unit.impl.Unit;
import org.example.ingekbe.unit.impl.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementServiceImpl implements MeasurementService{

    @Autowired
    MeasurementRepository repository;

    @Autowired
    CowRepository cowRepository;

    @Autowired
    UnitRepository unitRepository;

    public MeasurementDto save(MeasurementDto measurementDto) {
        Cow cow = findCow(measurementDto.cowId);
        Unit unit = findUnit(measurementDto.unitId);
        Measurement entity = repository.save(toEntity(measurementDto, cow, unit));
        return toDto(entity);
    }

    public MeasurementDto update(int id, MeasurementDto measurementDto) {
        Measurement existin = find(id);
        existin.cow = findCow(measurementDto.cowId);
        existin.unit = findUnit(measurementDto.unitId);
        existin.measurementDate = measurementDto.measurementDate;
        existin.weight =measurementDto.weight;
        existin.legLiftDuration = measurementDto.legLiftDuration;
        existin.lwr = measurementDto.lwr;
        existin.standardDeviation = measurementDto.standardDeviation;
        existin.numberOfLegMovements = measurementDto.numberOfLegMovements;
        existin.riskScore = measurementDto.riskScore;
        existin.asymmetryIndex = measurementDto.asymmetryIndex;
        existin = repository.save(existin);
        return toDto(existin);
    }

    public void delete(int id) {
        Measurement measurement = find(id);
        repository.delete(measurement);
    }

    public MeasurementDto get(int id) {return toDto(find(id));}

    public Measurement find(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Measurement not found: " + id));
    }

    private Cow findCow(int id) {
        return cowRepository.findById(id).orElseThrow(() -> new RuntimeException("Cow not found: " + id));
    }

    private Unit findUnit(int id) {
        return unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Unit not found: " + id));
    }



    public static MeasurementDto toDto(Measurement measurement) {
        MeasurementDto dto = new MeasurementDto();
        dto.measurementId = measurement.measurementId;
        dto.cowId = measurement.cow.cowId;
        dto.unitId = measurement.unit.unitId;
        dto.weight = measurement.weight;
        dto.lwr = measurement.lwr;
        dto.asymmetryIndex = measurement.asymmetryIndex;
        dto.legLiftDuration = measurement.legLiftDuration;
        dto.numberOfLegMovements = measurement.numberOfLegMovements;
        dto.standardDeviation = measurement.standardDeviation;
        dto.measurementDate =measurement.measurementDate;
        dto.riskScore = measurement.riskScore;
        return dto;
    }

    public static Measurement toEntity(MeasurementDto dto, Cow cow, Unit unit) {
        Measurement entitiy = new Measurement();
        entitiy.cow = cow;
        entitiy.unit = unit;
        entitiy.lwr = dto.lwr;
        entitiy.standardDeviation = dto.standardDeviation;
        entitiy.numberOfLegMovements = dto.numberOfLegMovements;
        entitiy.weight = dto.weight;
        entitiy.asymmetryIndex = dto.asymmetryIndex;
        entitiy.legLiftDuration = dto.legLiftDuration;
        entitiy.measurementDate = dto.measurementDate;
        entitiy.riskScore = dto.riskScore;
        return entitiy;
    }
}
