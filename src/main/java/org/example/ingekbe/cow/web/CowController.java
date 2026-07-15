package org.example.ingekbe.cow.web;


import org.example.ingekbe.cow.api.CowDto;
import org.example.ingekbe.cow.api.CowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("cow")

public class CowController {

    @Autowired
    CowService service;

    @PostMapping
    public CowResponse save(@RequestBody CowRequest cow) {
        CowDto dto = service.save(toDto(cow));
        return toResponse(dto);
    }


    @GetMapping("/id")
    public CowResponse find(@PathVariable int id) { return toResponse(service.get(id)); }

    @PutMapping("/id")
    public CowResponse update(@PathVariable int id,@RequestBody CowRequest cowRequest) {
        return toResponse(service.update(id, toDto(cowRequest)));
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable int id) {service.delete(id);}


    public CowResponse toResponse (CowDto dto) {
        CowResponse response = new CowResponse();
        response.setCowId(dto.getCowId());
        response.setFarmId(dto.getFarmId());
        response.setEarTagNumber(dto.getEarTagNumber());
        response.setAge(dto.getAge());
        response.setCowBreed(dto.getCowBreed());
        return response;
    }

    public CowDto toDto (CowRequest request) {
        CowDto dto = new CowDto();
        dto.setCowId(request.getCowId());
        dto.setFarmId(request.getFarmId());
        dto.setEarTagNumber(request.getEarTagNumber());
        dto.setAge(request.getAge());
        dto.setCowBreed(request.getCowBreed());

        return dto;
    }
}