package org.example.ingekbe.Cow.impl;

import org.example.ingekbe.Cow.api.CowDto;
import org.example.ingekbe.Cow.api.CowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CowServiceImpl implements CowService {

    @Autowired
    CowRepository repository;


    public CowDto save(CowDto Cow) {
        Cow entity = repository.save(toEntity(Cow));
        return toDto(entity);
    }

    public CowDto update(int id, CowDto cow) {
        Cow existinCow = find(id);
        existinCow.cowId = cow.cowId;
        existinCow.farmId = cow.farmId;
        existinCow.earTagNumber = cow.earTagNumber;
        existinCow.age = cow.age;
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
        return repository.findById(Integer.parseInt(id)).orElse(null);
    }


    public static CowDto toDto(Cow cow) {
        CowDto dto = new CowDto();
        dto.cowId = cow.cowId;
        dto.farmId = cow.farmId;
        dto.age = cow.age;
        dto.earTagNumber = cow.earTagNumber;
        dto.cowBreed = cow.cowBreed;
        return dto;
    }

    public static Cow toEntity(CowDto dto) {
        Cow entity = new Cow();
        entity.cowId = dto.cowId;
        entity.farmId = dto.farmId;
        entity.age = dto.age;
        entity.earTagNumber = dto.earTagNumber;
        entity.cowBreed = dto.cowBreed;
        return entity;
    }
}

