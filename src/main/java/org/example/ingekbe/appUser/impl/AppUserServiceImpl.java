package org.example.ingekbe.appUser.impl;

import jakarta.transaction.Transactional;
import org.example.ingekbe.appUser.api.AppUserDto;
import org.example.ingekbe.appUser.api.AppUserService;
import org.example.ingekbe.farm.impl.FarmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository repository;


    @Transactional
    public AppUserDto save(AppUserDto appUser) {
        AppUser entity = repository.save(toEntity(appUser));
        return toDto(entity);
    }

    @Transactional
    public AppUserDto update(int id, AppUserDto user) {
        AppUser existinUser = find(id);
        existinUser.firstName = user.firstName;
        existinUser.lastName = user.lastName;
        existinUser.email = user.email;
        existinUser.password = user.password;
        existinUser.job = user.job;
        existinUser = repository.save(existinUser);
        return toDto(existinUser);
    }


    public void delete(int id) {
        AppUser user = find(id);
        repository.delete(user);
    }

    @Transactional
    public AppUserDto get(int id) {
        return toDto(find(id));
    }

    @Transactional
    public AppUserDto findByEmail(String email) {
        AppUser appUser = repository.findByEmail(email).orElse(null);
        if (appUser == null) {
            return null;
        }
        return toDto(appUser);
    }

    public AppUser find(int id) {
        return repository.findById(id).orElse(null);
    }

    public static AppUserDto toDto(AppUser appUser) {
        AppUserDto dto = new AppUserDto();
        dto.appUserId = appUser.appUserId;
        dto.firstName = appUser.firstName;
        dto.lastName = appUser.lastName;
        dto.email   = appUser.email;
        dto.password = appUser.password;
        dto.job = appUser.job;
        if (appUser.farms != null) {
            dto.farms = appUser.farms.stream()
                    .map(FarmServiceImpl::toDto)
                    .collect(Collectors.toList());
        }
        return dto;
    }

    public static AppUser toEntity(AppUserDto dto) {
        AppUser entity = new AppUser();
        entity.firstName = dto.firstName;
        entity.lastName = dto.lastName;
        entity.email = dto.email;
        entity.password = dto.password;
        entity.job = dto.job;
        return entity;
    }



}

