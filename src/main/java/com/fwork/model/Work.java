package com.fwork.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Work {
	@Id
    private Integer workId;
    private String userId;
	private String freelanceId;
    private String mode;
    private Float dealAmount;
    private Integer duration;
    private String type;
    private String adminStatus;
    private String workStatus;
    private String description;
    private String imagePath;
    private Address address;
    private List<String> skills;

    public Work() {
    }

    public Work(Integer workId, String userId, String freelanceId, String mode, Float dealAmount, Integer duration, String type, String adminStatus, String workStatus, String description, String imagePath, Address address, List<String> skills) {
        this.workId = workId;
        this.userId = userId;
        this.freelanceId = freelanceId;
        this.mode = mode;
        this.dealAmount = dealAmount;
        this.duration = duration;
        this.type = type;
        this.adminStatus = adminStatus;
        this.workStatus = workStatus;
        this.description = description;
        this.imagePath = imagePath;
        this.address = address;
        this.skills = skills;
    }
    
    public Integer getWorkId() {
        return workId;
    }

    public String getUserId() {
        return userId;
    }

    public String getFreelanceId() {
        return freelanceId;
    }

    public String getMode() {
        return mode;
    }

    public Float getDealAmount() {
        return dealAmount;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getType() {
        return type;
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFreelanceId(String freelanceId) {
        this.freelanceId = freelanceId;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setDealAmount(Float dealAmount) {
        this.dealAmount = dealAmount;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Work{" +
                "workId=" + workId +
                ", userId='" + userId + '\'' +
                ", freelanceId='" + freelanceId + '\'' +
                ", mode='" + mode + '\'' +
                ", dealAmount=" + dealAmount +
                ", duration=" + duration +
                ", type='" + type + '\'' +
                ", adminStatus='" + adminStatus + '\'' +
                ", workStatus='" + workStatus + '\'' +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", address=" + address +
                ", skills=" + skills +
                '}';
    }
   
}
