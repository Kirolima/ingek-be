package org.example.ingekbe.Cow.api;

public interface CowService {

    public CowDto save(CowDto cow);
    public CowDto update(int id, CowDto cow);
    public void delete(int id);
    public CowDto get(int id);

}