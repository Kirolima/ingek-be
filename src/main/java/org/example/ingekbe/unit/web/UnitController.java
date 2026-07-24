package org.example.ingekbe.unit.web;
import org.example.ingekbe.measurement.api.MeasurementDto;
import org.example.ingekbe.measurement.web.MeasurementResponse;
import org.example.ingekbe.unit.api.UnitDto;
import org.example.ingekbe.unit.api.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("units")
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
        response.setUnitName(dto.getUnitName());
        response.setInstallationDate(dto.getInstallationDate());
        response.setFarmId(dto.getFarmId());

        if (dto.getMeasurements() != null) {
            response.setMeasurements(dto.getMeasurements().stream()
                    .map(this::toMeasurementResponse)
                    .collect(Collectors.toList()));
        }

        return response;
    }

    public MeasurementResponse toMeasurementResponse(MeasurementDto dto) {
        MeasurementResponse response = new MeasurementResponse();
        response.setMeasurementId(dto.getMeasurementId());
        response.setCowId(dto.getCowId());
        response.setUnitId(dto.getUnitId());
        response.setWeight(dto.getWeight());
        response.setStandardDeviation(dto.getStandardDeviation());
        response.setLwr(dto.getLwr());
        response.setLegLiftDuration(dto.getLegLiftDuration());
        response.setNumberOfLegMovements(dto.getNumberOfLegMovements());
        response.setAsymmetryIndex(dto.getAsymmetryIndex());
        response.setMeasurementDate(dto.getMeasurementDate());
        response.setRiskScore(dto.getRiskScore());
        return response;
    }

    public UnitDto toDto(UnitRequest request) {
        UnitDto dto = new UnitDto();
        dto.setUnitName(request.getUnitName());
        dto.setInstallationDate(request.getInstallationDate());
        dto.setFarmId(request.getFarmId());
        return dto;
    }
}