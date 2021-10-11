package com.example.imdonor;

public class userDataHelperClass {

    String bloodType, status, location, number, message, name;

    public userDataHelperClass() {

    }

    public userDataHelperClass(String bloodType, String status, String location, String name, String number, String message) {
        this.bloodType = bloodType;
        this.status = status;
        this.location = location;
        this.name = name;
        this.number = number;
        this.message = message;
    }


    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
