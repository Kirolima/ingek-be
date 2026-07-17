package org.example.ingekbe.unit.api;

public interface UnitService {
    public UnitDto save(UnitDto unit);
    public UnitDto update(int id, UnitDto unit);
    public void delete(int id);
    public UnitDto get(int id);
}
