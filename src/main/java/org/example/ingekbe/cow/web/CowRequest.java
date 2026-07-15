package org.example.ingekbe.cow.web;

public class CowRequest {

    public int cowId;
    public int farmId;
    public String earTagNumber;
    public int age;
    public String cowBreed;

    public int getCowId() {
        return cowId;
    }

    public void setCowId(int cowId) {
        this.cowId = cowId;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public String getEarTagNumber() {
        return earTagNumber;
    }

    public void setEarTagNumber(String earTagNumber) {
        this.earTagNumber = earTagNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCowBreed() {
        return cowBreed;
    }

    public void setCowBreed(String cowBreed) {
        this.cowBreed = cowBreed;
    }

}
