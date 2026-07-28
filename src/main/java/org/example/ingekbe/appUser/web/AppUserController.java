package org.example.ingekbe.appUser.web;


import org.example.ingekbe.appUser.api.AppUserDto;
import org.example.ingekbe.appUser.api.AppUserService;
import org.example.ingekbe.farm.api.FarmDto;
import org.example.ingekbe.farm.web.FarmResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("app-users")
public class AppUserController {
    //read icin get
    // update icin put
    // create icin post
    //silmek icin delete
    //dependency injection

    @Autowired
    AppUserService service;

    @PostMapping
    public AppUserResponse save(@RequestBody AppUserRequest appUser) {
        AppUserDto dto = service.save(toDto(appUser));
        return toResponse(dto);
    }

    @PostMapping("/login")
    public AppUserResponse login(@RequestBody AppUserRequest loginRequest) {
        // Servis katmanından kullanıcının girdiği email'e göre o kişiyi buluyoruz
        AppUserDto user = service.findByEmail(loginRequest.getEmail());
        
        // Kullanıcı veritabanında varsa VE şifresi eşleşiyorsa içeri al!
        if (user != null && user.getPassword() != null && user.getPassword().equals(loginRequest.getPassword())) {
            return toResponse(user); // Başarılı girişte temiz model döner
        } else {
            // Şifre yanlışsa veya email yoksa API hata fırlatır
            throw new RuntimeException("Hatalı e-posta veya şifre!"); 
        }
    }


    @GetMapping("/{id}")
    public AppUserResponse find(@PathVariable int id) {
        return toResponse(service.get(id));
    }

    @PutMapping("/{id}")
    public AppUserResponse update(@PathVariable int id, @RequestBody AppUserRequest appUser) {
        return toResponse(service.update(id, toDto(appUser)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }


    public AppUserResponse toResponse(AppUserDto dto) {
        AppUserResponse response = new AppUserResponse();
        response.setAppUserId(dto.getAppUserId());
        response.setFirstName(dto.getFirstName());
        response.setLastName(dto.getLastName());
        response.setPassword(dto.getPassword());  //dişari şifre dönülmez
        response.setEmail(dto.getEmail());
        response.setJob(dto.getJob());

        if (dto.getFarms() != null) {
            response.setFarms(dto.getFarms().stream()
                    .map(this::toFarmResponse)
                    .collect(Collectors.toList()));
        }
        return response;
    }

    public FarmResponse toFarmResponse(FarmDto dto) {
        FarmResponse response = new FarmResponse();
        response.setFarmId(dto.getFarmId());
        response.setFarmName(dto.getFarmName());
        response.setLocation(dto.getLocation());
        response.setAppUserId(dto.getAppUserId());
        return response;
    }

    public AppUserDto toDto(AppUserRequest request) {
        AppUserDto dto = new AppUserDto();
        dto.setAppUserId(request.getAppUserId());
        dto.setFirstName(request.getFirstName());
        dto.setLastName(request.getLastName());
        dto.setPassword(request.getPassword());
        dto.setEmail(request.getEmail());
        dto.setJob(request.getJob());
        dto.setPassword(request.getPassword());
        return dto;
    }

}
