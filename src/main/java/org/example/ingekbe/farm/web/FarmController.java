package org.example.ingekbe.farm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.ingekbe.farm.api.FarmDto;
import org.example.ingekbe.farm.api.FarmService;

@RestController
@RequestMapping("farm")
public class FarmController {

    @Autowired
    FarmService service;

    @PostMapping
    public FarmResponse save(@RequestBody FarmRequest farmRequest) {
        FarmDto dto = service.save(toDto(farmRequest));
        return toResponse(dto);
    }

    @GetMapping("/{id}")
    public FarmResponse find(@PathVariable int id) {return toResponse(service.get(id));}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {service.delete(id);}

    @PutMapping("/{id}")
    public FarmResponse update(@PathVariable int id,@RequestBody FarmRequest farmRequest) {
        return toResponse(service.update(id, toDto(farmRequest)));
    }

    public FarmResponse toResponse(FarmDto dto) {
        FarmResponse response = new FarmResponse();
        response.setFarmId(dto.getFarmId());
        response.setAppUserId(dto.getAppUserId());
        response.setCowOfNumber(dto.getCowOfNumber());
        response.setFarmName(dto.getFarmName());
        response.setLocation(dto.getLocation());
        response.setNumberOfUnits(dto.getNumberOfUnits());
        return response;
    }

    public FarmDto toDto (FarmRequest request) {
        FarmDto dto = new FarmDto();
        dto.setFarmId(request.getFarmId());
        dto.setAppUserId(request.getAppUserId());
        dto.setFarmName(request.getFarmName());
        dto.setCowOfNumber(request.getCowOfNumber());
        dto.setLocation(request.getLocation());
        dto.setNumberOfUnits(request.getNumberOfUnits());
        return dto;
    }
}

