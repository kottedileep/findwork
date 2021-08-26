package com.fwork.services;

import java.util.List;

import com.fwork.exceptions.FreelancerNotFoundException;
import com.fwork.model.Freelancer;

public interface FreelancerService {
	public Freelancer getByFreelanceId(String id) throws FreelancerNotFoundException;
	
	public List<Freelancer> getByFreelanceName(String name) throws FreelancerNotFoundException;
	
	public List<Freelancer> getBySkill(List<String> skills) throws FreelancerNotFoundException;
	
	public List<Freelancer> getByLocation(String location) throws FreelancerNotFoundException;
	
	public List<Freelancer> getBySkillsAndLocation(List<String> skills,String city) throws FreelancerNotFoundException;
	
	public List<Freelancer> allFreelancer();
	
	public Freelancer addFreelancer(Freelancer freelancer);
	
	public void updateFreelancer(Freelancer freelancer) ;
}
