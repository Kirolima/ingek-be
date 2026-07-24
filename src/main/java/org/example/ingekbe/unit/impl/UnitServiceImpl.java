package org.example.ingekbe.unit.impl;

import jakarta.transaction.Transactional;
import org.example.ingekbe.farm.impl.Farm;
import org.example.ingekbe.farm.impl.FarmRepository;
import org.example.ingekbe.measurement.impl.MeasurementServiceImpl;
import org.example.ingekbe.unit.api.UnitDto;
import org.example.ingekbe.unit.api.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UnitServiceImpl implements UnitService{

    @Autowired
    UnitRepository repository;

    @Autowired
    FarmRepository farmRepository;

    @Transactional
    public UnitDto save(UnitDto unit) {
        Farm farm = findFarm(unit.farmId);
        Unit entity = repository.save(toEntity(unit, farm));
        return toDto(entity);
    }

    @Transactional
    public UnitDto update(int id, UnitDto unit) {
        Unit existinUnit = find(id);
        existinUnit.unitName = unit.unitName;
        existinUnit.installationDate = unit.installationDate;
        existinUnit.farm = findFarm(unit.farmId);
        existinUnit = repository.save(existinUnit);
        return toDto(existinUnit);
    }

    public void delete(int id) {
        Unit unit = find(id);
        repository.delete(unit);
    }
    @Transactional
    public UnitDto get(int id) {return toDto(find(id));}

    public Unit find(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Unit not found: " + id));
    }

    public Farm findFarm(int id) {
        return farmRepository.findById(id).orElseThrow(() -> new RuntimeException("Farm not found: " + id));
    }

    public static UnitDto toDto(Unit unit) {
        if (unit == null) return null;

        UnitDto dto = new UnitDto();
        dto.setUnitId(unit.getUnitId());
        dto.setUnitName(unit.getUnitName());
        dto.setInstallationDate(unit.getInstallationDate());

        if (unit.getFarm() != null) {
            dto.setFarmId(unit.getFarm().getFarmId());
        }

        if (unit.getMeasurements() != null) {
            dto.setMeasurements(unit.getMeasurements().stream()
                    .map(MeasurementServiceImpl::toDto)
                    .collect(Collectors.toList()));
        }

        return dto;
    }


    public static Unit toEntity(UnitDto dto, Farm farm) {
        Unit entity = new Unit();
        entity.farm = farm;
        entity.unitName = dto.unitName;
        entity.installationDate = dto.installationDate;
        return entity;
    }
}
