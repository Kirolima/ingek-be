package org.example.ingekbe.farm.impl;

import org.example.ingekbe.farm.api.FarmDto;
import org.example.ingekbe.farm.api.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmServiceImpl implements FarmService{

    @Autowired
    FarmRepository repository;

    public FarmDto save(FarmDto farm) {

        Farm entity = repository.save(toEntity(farm));
        return toDto(entity);
    }

    public FarmDto update(int id, FarmDto farm) {
        Farm existinFarm = find(id);
        existinFarm.appUserId = farm.appUserId;
        existinFarm.farmName = farm.farmName;
        existinFarm.cowOfNumber = farm.cowOfNumber;
        existinFarm.numberOfUnits = farm.numberOfUnits;
        existinFarm.location = farm.location;
        return toDto(existinFarm);
    }

    public  void delete (int id) {
        Farm farm = find(id);
        repository.delete(farm);
    }

    public FarmDto get(int id) {return toDto(find(id));}


    public Farm find(int id) {
        return repository.findById(id).orElse(null);
    }


    public static FarmDto toDto(Farm farm) {

        FarmDto dto = new FarmDto();
        dto.farmId = farm.farmId;
        dto.appUserId = farm.appUserId;
        dto.farmName = farm.farmName;
        dto.cowOfNumber = farm.cowOfNumber;
        dto.location = farm.location;
        dto.numberOfUnits = farm.numberOfUnits;
        return dto;
    }

    public static Farm toEntity(FarmDto dto) {

        Farm entity = new Farm();
        entity.appUserId = dto.appUserId;
        entity.farmName = dto.farmName;
        entity.cowOfNumber = dto.cowOfNumber;
        entity.location =dto.location;
        entity.numberOfUnits = dto.numberOfUnits;
        return entity;
    }
}
