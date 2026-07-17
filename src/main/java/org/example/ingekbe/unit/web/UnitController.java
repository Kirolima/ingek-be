package org.example.ingekbe.unit.web;
import org.example.ingekbe.unit.api.UnitDto;
import org.example.ingekbe.unit.api.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("unit")
public class UnitController {

    @Autowired
    UnitService service;

    @PostMapping
    public UnitResponse save(@RequestBody UnitRequest request) {
        UnitDto dto = service.save(toDto(request));
        return toResponse(dto);
    }

    @GetMapping("/{id}")
    public UnitResponse find(@PathVariable  int id) {return toResponse(service.get(id));}

    @PutMapping("/{id}")
    public UnitResponse update(@PathVariable int id, @RequestBody UnitRequest request) {
        return toResponse(service.update(id,toDto(request)));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {service.delete(id);}

    public UnitResponse toResponse(UnitDto dto) {
        UnitResponse response = new UnitResponse();
        response.setUnitId(dto.getUnitId());
        response.setFarmId(dto.getFarmId());
        response.setInstallationDate(dto.getInstallationDate());
        response.setUnitName(dto.getUnitName());
        return response;
    }

    public UnitDto toDto (UnitRequest request) {
        UnitDto dto = new UnitDto();
        dto.setFarmId(request.getFarmId());
        dto.setUnitId(request.getUnitId());
        dto.setInstallationDate(request.getInstallationDate());
        dto.setUnitName(request.getUnitName());
        return dto;
    }
}
