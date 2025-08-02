package com.example.reporra.data.model;

public class AreaModel {
    private String areaName;
    private String areaCode;
    private String areaType;
    private long timestamp;

    public AreaModel() {
        // Firestore needs empty constructor
    }

    public AreaModel(String areaName, String areaCode, String areaType, long timestamp) {
        this.areaName = areaName;
        this.areaCode = areaCode;
        this.areaType = areaType;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}