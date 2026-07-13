package org.example.ingekbe.appUser.web;


import org.example.ingekbe.appUser.api.AppUserDto;
import org.example.ingekbe.appUser.api.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public AppUserResponse find(@PathVariable String id) {
        return toResponse(service.get(id));
    }

    @PutMapping("/{id}")
    public AppUserResponse update(@PathVariable String id, @RequestBody AppUserRequest appUser) {
        return toResponse(service.update(id, toDto(appUser)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }


    public AppUserResponse toResponse(AppUserDto dto) {
        AppUserResponse response = new AppUserResponse();
        response.setAppUserId(dto.getAppUserId());
        response.setFirstName(dto.getFirstName());
        response.setLastName(dto.getLastName());
        response.setPassword(dto.getPassword());
        response.setEmail(dto.getEmail());
        response.setJob(dto.getJob());
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
        return dto;
    }

}
