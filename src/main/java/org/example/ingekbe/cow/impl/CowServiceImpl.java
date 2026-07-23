package org.example.ingekbe.cow.impl;

import org.example.ingekbe.cow.api.CowDto;
import org.example.ingekbe.cow.api.CowService;
import org.example.ingekbe.farm.impl.Farm;
import org.example.ingekbe.farm.impl.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CowServiceImpl implements CowService {

    @Autowired
    CowRepository repository;

    @Autowired
    FarmRepository farmRepository;


    public CowDto save(CowDto Cow) {
        Farm farm = findFarm(Cow.farmId);
        Cow entity = repository.save(toEntity(Cow, farm));
        return toDto(entity);
    }

    public CowDto update(int id, CowDto cow) {
        Cow existinCow = find(id);
        existinCow.farm = findFarm(cow.farmId);
        existinCow.earTagNumber = cow.earTagNumber;
        existinCow.age = cow.age;
        existinCow.cowBreed = cow.cowBreed;
        existinCow = repository.save(existinCow);
        return toDto(existinCow);
    }


    public void delete(int id) {
        Cow cow = find(id);
        repository.delete(cow);
    }

    public CowDto get(int id) {
        return toDto(find(id));
    }


    public Cow find(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cow not found: " + id));
    }

    private Farm findFarm(int id) {
        return farmRepository.findById(id).orElseThrow(() -> new RuntimeException("Farm not found: " + id));
    }


    public static CowDto toDto(Cow cow) {
        CowDto dto = new CowDto();
        dto.cowId = cow.cowId;
        dto.farmId = cow.farm.farmId;
        dto.age = cow.age;
        dto.earTagNumber = cow.earTagNumber;
        dto.cowBreed = cow.cowBreed;
        return dto;
    }

    public static Cow toEntity(CowDto dto, Farm farm) {
        Cow entity = new Cow();
        entity.farm = farm;
        entity.age = dto.age;
        entity.earTagNumber = dto.earTagNumber;
        entity.cowBreed = dto.cowBreed;
        return entity;
    }
}

