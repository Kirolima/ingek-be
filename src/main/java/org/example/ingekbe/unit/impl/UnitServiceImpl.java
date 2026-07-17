package org.example.ingekbe.unit.impl;

import org.example.ingekbe.appUser.impl.AppUser;
import org.example.ingekbe.unit.api.UnitDto;
import org.example.ingekbe.unit.api.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl implements UnitService{

    @Autowired
    UnitRepository repository;

    public UnitDto save(UnitDto unit) {
        Unit entity = repository.save(toEntity(unit));
        return toDto(entity);
    }

    public UnitDto update(int id, UnitDto unit) {
        Unit existinUnit = find(id);
        existinUnit.unitId = unit.unitId;
        existinUnit.unitName = unit.unitName;
        existinUnit.installationDate = unit.installationDate;
        existinUnit.farmId = unit.farmId;
        return toDto(existinUnit);
    }

    public void delete(int id) {
        Unit unit = find(id);
        repository.delete(unit);
    }

    public UnitDto get(int id) {return toDto(find(id));}

    public Unit find(int id) {
        return repository.findById(id).orElse(null);
    }

    public static UnitDto toDto(Unit unit) {
        UnitDto dto = new UnitDto();
        dto.installationDate = unit.installationDate;
        dto.unitId = unit.unitId;
        dto.farmId = unit.farmId;
        dto.unitName = unit.unitName;
        return dto;
    }


    public static Unit toEntity(UnitDto dto) {
        Unit entity = new Unit();
        entity.farmId = dto.farmId;
        entity.unitId = dto.unitId;
        entity.unitName = dto.unitName;
        entity.installationDate = dto.installationDate;
        return entity;
    }
}
