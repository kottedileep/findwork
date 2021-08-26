package com.fwork.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
   
}
