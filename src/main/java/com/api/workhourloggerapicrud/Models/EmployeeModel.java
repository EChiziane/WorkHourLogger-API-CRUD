package com.api.workhourloggerapicrud.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_EMPLOYEE")
public class EmployeeModel {
    private static final long serialVersionUID = 1L;
    @Id // Marks the field as the primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Generates automatically the value for the field
    private UUID id; // Field for storing the identifier
    @Column(nullable = false, length = 60)
    private String name;
    @Column(nullable = false, length = 60)
    private String position;
    @Column(nullable = false, length = 9)
    private String phoneNumber;
    @Column(nullable = false, length = 9)
    private String staffCode;
    @Column(nullable = false, length = 60)
    private LocalDateTime entryTime;
    @Column(nullable = false, length = 60)
    private LocalDateTime exitTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}
