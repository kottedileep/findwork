package com.fwork.model;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

	public Freelancer() {
	}

	public Freelancer(String userId, String password, String firstName, String lastName, String mobileNum, String emailId, String passwd, String aboutMe, String profilePath, Address address, List<String> skills) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNum = mobileNum;
		this.emailId = emailId;
		this.passwd = passwd;
		this.aboutMe = aboutMe;
		this.profilePath = profilePath;
		this.address = address;
		this.skills = skills;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Freelancer{" +
				"userId='" + userId + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", mobileNum='" + mobileNum + '\'' +
				", emailId='" + emailId + '\'' +
				", passwd='" + passwd + '\'' +
				", aboutMe='" + aboutMe + '\'' +
				", profilePath='" + profilePath + '\'' +
				", address=" + address +
				", skills=" + skills +
				'}';
	}
}
