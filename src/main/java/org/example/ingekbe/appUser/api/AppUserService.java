package org.example.ingekbe.appUser.api;

public interface AppUserService {

    public AppUserDto save(AppUserDto appUser);
    public AppUserDto update(int id, AppUserDto appUser);
    public void delete(int id);
    public AppUserDto get(int id);
    public AppUserDto findByEmail(String email);

}

