package org.example.ingekbe.cow.impl;

import jakarta.transaction.Transactional;
import org.example.ingekbe.cow.api.CowDto;
import org.example.ingekbe.cow.api.CowService;
import org.example.ingekbe.farm.impl.Farm;
import org.example.ingekbe.farm.impl.FarmRepository;
import org.example.ingekbe.measurement.impl.MeasurementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CowServiceImpl implements CowService {

    @Autowired
    CowRepository repository;

    @Autowired
    FarmRepository farmRepository;


    @Override
    @Transactional
    public CowDto save(CowDto cow) {
        Farm farm = findFarm(cow.farmId);
        Cow entity = repository.save(toEntity(cow, farm));
        return toDto(entity);
    }
    @Transactional
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
    @Transactional
    public CowDto get(int id) {
        return toDto(find(id));
    }


    public Cow find(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cow not found: " + id));
    }

    public Farm findFarm(int id) {
        return farmRepository.findById(id).orElseThrow(() -> new RuntimeException("Farm not found: " + id));
    }


    public static CowDto toDto(Cow cow) {
        if (cow == null) return null;

        CowDto dto = new CowDto();
        dto.setCowId(cow.getCowId());
        dto.setCowBreed(cow.getCowBreed());
        dto.setAge(cow.getAge());
        dto.setEarTagNumber(cow.getEarTagNumber());

        if (cow.getFarm() != null) {
            dto.setFarmId(cow.getFarm().getFarmId());
        }

        if (cow.getMeasurements() != null) {
            dto.setMeasurements(cow.getMeasurements().stream()
                    .map(MeasurementServiceImpl::toDto)
                    .collect(Collectors.toList()));
        }

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

