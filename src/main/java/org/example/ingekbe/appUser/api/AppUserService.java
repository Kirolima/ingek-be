package org.example.ingekbe.appUser.api;

public interface AppUserService {

    public AppUserDto save(AppUserDto appUser);
    public AppUserDto update(String id, AppUserDto appUser);
    public void delete(String id);
    public AppUserDto get(String id);

}
