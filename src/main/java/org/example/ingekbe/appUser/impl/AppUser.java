package org.example.ingekbe.appUser.impl;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int appUserId;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String job;

}
