package org.example.ingekbe.measurement.impl;

import jakarta.transaction.Transactional;
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


    @Transactional
    public MeasurementDto save(MeasurementDto measurementDto) {
        Cow cow = findCow(measurementDto.cowId);
        Unit unit = findUnit(measurementDto.unitId);
        Measurement entity = repository.save(toEntity(measurementDto, cow, unit));
        return toDto(entity);
    }
    @Transactional
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
    @Transactional
    public MeasurementDto get(int id) {return toDto(find(id));}

    @Transactional
    public Measurement find(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Measurement not found: " + id));
    }

    public Cow findCow(int id) {
        return cowRepository.findById(id).orElseThrow(() -> new RuntimeException("Cow not found: " + id));
    }

    public Unit findUnit(int id) {
        return unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Unit not found: " + id));
    }


    public static MeasurementDto toDto(Measurement measurement) {
        if (measurement == null) return null;

        MeasurementDto dto = new MeasurementDto();
        dto.setMeasurementId(measurement.getMeasurementId());

        if (measurement.getCow() != null) {
            dto.setCowId(measurement.getCow().getCowId());
        }
        if (measurement.getUnit() != null) {
            dto.setUnitId(measurement.getUnit().getUnitId());
        }
        dto.setWeight(measurement.getWeight());
        dto.setLwr(measurement.getLwr());
        dto.setAsymmetryIndex(measurement.getAsymmetryIndex());
        dto.setLegLiftDuration(measurement.getLegLiftDuration());
        dto.setNumberOfLegMovements(measurement.getNumberOfLegMovements());
        dto.setStandardDeviation(measurement.getStandardDeviation());
        dto.setMeasurementDate(measurement.getMeasurementDate());
        dto.setRiskScore(measurement.getRiskScore());
        return dto;
    }

    public static Measurement toEntity(MeasurementDto dto, Cow cow, Unit unit) {
        if (dto == null) return null;

        Measurement entity = new Measurement();
        entity.setCow(cow);
        entity.setUnit(unit);
        entity.setLwr(dto.getLwr());
        entity.setStandardDeviation(dto.getStandardDeviation());
        entity.setNumberOfLegMovements(dto.getNumberOfLegMovements());
        entity.setWeight(dto.getWeight());
        entity.setAsymmetryIndex(dto.getAsymmetryIndex());
        entity.setLegLiftDuration(dto.getLegLiftDuration());
        entity.setMeasurementDate(dto.getMeasurementDate());
        entity.setRiskScore(dto.getRiskScore());
        return entity;
    }
}