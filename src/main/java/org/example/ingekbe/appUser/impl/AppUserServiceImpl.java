package org.example.ingekbe.appUser.impl;

import org.example.ingekbe.appUser.api.AppUserDto;
import org.example.ingekbe.appUser.api.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository repository;


    public AppUserDto save(AppUserDto appUser) {
        AppUser entity = repository.save(toEntity(appUser));
        return toDto(entity);
    }

    public AppUserDto update(String id, AppUserDto user) {
        AppUser existinUser = find(id);
        existinUser.firstName = user.firstName;
        existinUser.lastName = user.lastName;
        existinUser.email = user.email;
        existinUser.password = user.password;
        existinUser.job = user.job;
        existinUser = repository.save(existinUser);
        return toDto(existinUser);
    }


    public void delete(String id) {
        AppUser user = find(id);
        repository.delete(user);
    }

    public AppUserDto get(String id) {
        return toDto(find(id));
    }


    public AppUser find(String id) {
        return repository.findById(Integer.parseInt(id)).orElse(null);
    }


    public static AppUserDto toDto(AppUser appUser) {
        AppUserDto dto = new AppUserDto();
        dto.appUserId = appUser.appUserId;
        dto.firstName = appUser.firstName;
        dto.lastName = appUser.lastName;
        dto.email   = appUser.email;
        dto.password = appUser.password;
        dto.job = appUser.job;
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

