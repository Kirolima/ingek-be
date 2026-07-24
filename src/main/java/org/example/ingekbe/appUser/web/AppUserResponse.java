package org.example.ingekbe.appUser.web;


import org.example.ingekbe.farm.api.FarmDto;
import org.example.ingekbe.farm.web.FarmResponse;

import java.util.List;

    public class AppUserResponse {

        public int appUserId;
        public String firstName;
        public String lastName;
        public String job;
        public String email;
        // public String password;

        public List<FarmResponse> farms;

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<FarmResponse> getFarms() {
        return farms;
    }

    public void setFarms(List<FarmResponse> farms) {
        this.farms = farms;
    }
}
