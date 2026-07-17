package org.example.ingekbe.farm.api;

public interface FarmService {

    public FarmDto save(FarmDto farm);
    public FarmDto update(int id, FarmDto farm);
    public void delete(int id);
    public FarmDto get(int id);
}
