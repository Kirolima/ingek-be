package org.example.ingekbe.farm.web;

import org.example.ingekbe.cow.api.CowDto;
import org.example.ingekbe.cow.web.CowResponse;
import org.example.ingekbe.farm.api.FarmDto;
import org.example.ingekbe.farm.api.FarmService;
import org.example.ingekbe.measurement.api.MeasurementDto;
import org.example.ingekbe.measurement.web.MeasurementResponse;
import org.example.ingekbe.unit.api.UnitDto;
import org.example.ingekbe.unit.web.UnitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("farms")
public class FarmController {

    @Autowired
    FarmService service;

    @PostMapping
    public FarmResponse save(@RequestBody FarmRequest farmRequest) {
        FarmDto dto = service.save(toDto(farmRequest));
        return toResponse(dto);
    }

    @GetMapping("/{id}")
    public FarmResponse find(@PathVariable int id) {
        return toResponse(service.get(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public FarmResponse update(@PathVariable int id, @RequestBody FarmRequest farmRequest) {
        return toResponse(service.update(id, toDto(farmRequest)));
    }





    public FarmResponse toResponse(FarmDto dto) {
        FarmResponse response = new FarmResponse();
        response.setFarmId(dto.getFarmId());
        response.setAppUserId(dto.getAppUserId());
        response.setFarmName(dto.getFarmName());
        response.setLocation(dto.getLocation());

        if (dto.getCows() != null) {
            response.setCows(dto.getCows().stream()
                    .map(this::toCowResponse)
                    .collect(Collectors.toList()));
        }

        if (dto.getUnits() != null) {
            response.setUnits(dto.getUnits().stream()
                    .map(this::toUnitResponse)
                    .collect(Collectors.toList()));
        }

        return response;
    }

    public CowResponse toCowResponse(CowDto dto) {
        CowResponse response = new CowResponse();
        response.setCowId(dto.getCowId());
        response.setFarmId(dto.getFarmId());
        response.setEarTagNumber(dto.getEarTagNumber());
        response.setAge(dto.getAge());
        response.setCowBreed(dto.getCowBreed());

        if (dto.getMeasurements() != null) {
            response.setMeasurements(dto.getMeasurements().stream()
                    .map(this::toMeasurementResponse)
                    .collect(Collectors.toList()));
        }

        return response;
    }

    public UnitResponse toUnitResponse(UnitDto dto) {
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
        if (dto == null) return null;

        MeasurementResponse response = new MeasurementResponse();
        response.setMeasurementId(dto.getMeasurementId());
        response.setCowId(dto.getCowId());
        response.setUnitId(dto.getUnitId());
        response.setWeight(dto.getWeight());
        response.setLwr(dto.getLwr());
        response.setAsymmetryIndex(dto.getAsymmetryIndex());
        response.setLegLiftDuration(dto.getLegLiftDuration());
        response.setNumberOfLegMovements(dto.getNumberOfLegMovements());
        response.setStandardDeviation(dto.getStandardDeviation());
        response.setMeasurementDate(dto.getMeasurementDate());
        response.setRiskScore(dto.getRiskScore());
        return response;
    }

    public FarmDto toDto(FarmRequest request) {
        FarmDto dto = new FarmDto();
        dto.setFarmId(request.getFarmId());
        dto.setAppUserId(request.getAppUserId());
        dto.setFarmName(request.getFarmName());
        dto.setLocation(request.getLocation());
        return dto;
    }
}