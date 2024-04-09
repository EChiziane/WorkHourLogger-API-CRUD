package com.api.workhourloggerapicrud.Dtos;

import jakarta.validation.constraints.NotBlank;

public class EmployeeDto {
    @NotBlank
    private String name;
    @NotBlank
    private String position;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String staffCode;
    @NotBlank
    private String entryTime;
    @NotBlank
    private String exitTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }
}
