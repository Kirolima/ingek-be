package org.example.ingekbe.farm.impl;

import jakarta.transaction.Transactional;
import org.example.ingekbe.appUser.impl.AppUser;
import org.example.ingekbe.appUser.impl.AppUserRepository;
import org.example.ingekbe.cow.impl.CowServiceImpl;
import org.example.ingekbe.farm.api.FarmDto;
import org.example.ingekbe.farm.api.FarmService;
import org.example.ingekbe.unit.impl.UnitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class FarmServiceImpl implements FarmService{

    @Autowired
    FarmRepository repository;

    @Autowired
    AppUserRepository appUserRepository;


   @Transactional
    public FarmDto save(FarmDto farm) {

        AppUser appUser = findAppUser(farm.appUserId);
        Farm entity = repository.save(toEntity(farm, appUser));
        return toDto(entity);
    }

    @Transactional
    public FarmDto update(int id, FarmDto farm) {
        Farm existinFarm = find(id);
        existinFarm.appUser = findAppUser(farm.appUserId);
        existinFarm.farmName = farm.farmName;
        existinFarm.location = farm.location;
        existinFarm = repository.save(existinFarm);
        return toDto(existinFarm);
    }

    public  void delete (int id) {
        Farm farm = find(id);
        repository.delete(farm);
    }

    @Transactional
    public FarmDto get(int id) {return toDto(find(id));}


    public Farm find(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Farm not found: " + id));
    }

    public AppUser findAppUser(int id) {
        return appUserRepository.findById(id).orElseThrow(() -> new RuntimeException("AppUser not found: " + id));
    }


    public static FarmDto toDto(Farm farm) {
        if (farm == null) return null;

        FarmDto dto = new FarmDto();
        dto.setFarmId(farm.getFarmId());
        dto.setFarmName(farm.getFarmName());
        dto.setLocation(farm.getLocation());

        if (farm.getAppUser() != null) {
            dto.setAppUserId(farm.getAppUser().getAppUserId());
        }

        if (farm.getCows() != null) {
            dto.setCows(farm.getCows().stream()
                    .map(CowServiceImpl::toDto)
                    .collect(Collectors.toList()));
        }

        if (farm.getUnits() != null) {
            dto.setUnits(farm.getUnits().stream()
                    .map(UnitServiceImpl::toDto)
                    .collect(Collectors.toList()));
        }
        return dto;
    }
    public static Farm toEntity(FarmDto dto, AppUser appUser) {
        Farm entity = new Farm();
        entity.appUser = appUser;
        entity.farmName = dto.farmName;
        entity.location = dto.location;
        return entity;
    }
}