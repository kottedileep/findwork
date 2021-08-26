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
public class Freelancer {
	@Id
	private String userId;
	private String firstName;
	private String lastName;
	private String mobileNum;
	private String emailId;
	private String passwd;
	private String aboutMe;
	private String profilePath;
	private Address address;
	private List<String> skills;
}
