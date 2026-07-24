package org.example.ingekbe.measurement.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.ingekbe.measurement.api.MeasurementDto;
import org.example.ingekbe.measurement.api.MeasurementService;

@RestController
    @RequestMapping("measurements")
public class MeasurementController {

    @Autowired
    MeasurementService service;

    @PostMapping
    public MeasurementResponse save(@RequestBody MeasurementRequest request) {
        MeasurementDto dto = service.save(toDto(request));
        return toResponse(dto);
    }

    @GetMapping("/{id}")
    public MeasurementResponse get(@PathVariable int id) { return toResponse(service.get(id));}

    @PutMapping("/{id}")
    public MeasurementResponse update(@PathVariable int id,@RequestBody MeasurementRequest request) {
        return toResponse(service.update(id, toDto(request)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) { service.delete(id);}

    public MeasurementResponse toResponse(MeasurementDto dto) {
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

    public MeasurementDto toDto (MeasurementRequest request) {
        MeasurementDto dto = new MeasurementDto();
        dto.setMeasurementId(request.getMeasurementId());
        dto.setCowId(request.getCowId());
        dto.setUnitId(request.getUnitId());
        dto.setWeight(request.getWeight());
        dto.setStandardDeviation(request.getStandardDeviation());
        dto.setLwr(request.getLwr());
        dto.setLegLiftDuration(request.getLegLiftDuration());
        dto.setNumberOfLegMovements(request.getNumberOfLegMovements());
        dto.setAsymmetryIndex(request.getAsymmetryIndex());
        dto.setMeasurementDate(request.getMeasurementDate());
        dto.setRiskScore(request.getRiskScore());;
        return dto;
    }
}
