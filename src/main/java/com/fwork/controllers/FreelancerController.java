package com.fwork.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fwork.model.Freelancer;
import com.fwork.services.FreelancerService;


@RestController
@RequestMapping("find-freelancer")
public class FreelancerController {
@Autowired
FreelancerService freelancerservice;
@GetMapping("/all")
public ResponseEntity<List<Freelancer>> allFreelancers(){
	List<Freelancer> freelancerList= freelancerservice.allFreelancer();
	HttpHeaders headers=new HttpHeaders();
	headers.add("desc", "Getting All Freelancers list");
	return ResponseEntity.ok().headers(headers).body(freelancerList);
}

@GetMapping("/id/{id}")
public ResponseEntity<Freelancer> getFreelancerById(@PathVariable("id") String id) {
	Freelancer freelancer =  freelancerservice.getByFreelanceId(id);
	HttpHeaders headers=new HttpHeaders();
	headers.add("desc","Getting Freelancer by id");
	return ResponseEntity.ok().headers(headers).body(freelancer);
}

@GetMapping("/name/{name}")
public ResponseEntity<List<Freelancer>> getFreelancerByName(@PathVariable("name") String name) {
	List<Freelancer> freelancerList =  freelancerservice.getByFreelanceName(name);
	HttpHeaders headers=new HttpHeaders();
	headers.add("desc","Getting Freelancers By Name");
	return ResponseEntity.ok().headers(headers).body(freelancerList);
}

@GetMapping("/skill/{skills}")
public ResponseEntity<List<Freelancer>> getFreelancerBySkills(@PathVariable("skills") List<String> skills){
	List<Freelancer> freelancerList = freelancerservice.getBySkill(skills);
	HttpHeaders headers=new HttpHeaders();
	headers.add("desc", "Getting Freelancers by Skills");
	return ResponseEntity.ok().headers(headers).body(freelancerList);
}

@GetMapping("/location/{location}")
public ResponseEntity<List<Freelancer>> getFreelancerByCity(@PathVariable("location") String location){
	List<Freelancer> freelancerList= freelancerservice.getByLocation(location);
	HttpHeaders headers=new HttpHeaders();
	headers.add("desc","Getting Freelancers by location");
	return ResponseEntity.ok().headers(headers).body(freelancerList);
}

@GetMapping("/skill/{skills}/location/{location}")
public ResponseEntity<List<Freelancer>> getFreelancerByCityAndSkills(@PathVariable("skills") List<String> skills,@PathVariable("location")String location){
	List<Freelancer>  freelancerList=freelancerservice.getBySkillsAndLocation(skills, location);
	HttpHeaders headers=new HttpHeaders();
	headers.add("desc","Getting Freelancers by location and skills");
	return ResponseEntity.ok().headers(headers).body(freelancerList);
}

@PatchMapping("/update/{id}")
public ResponseEntity<Void> updateFreelanceById(@RequestBody Freelancer freelancer,@PathVariable("id") String id){
	Freelancer freelance=freelancerservice.getByFreelanceId(id);
	freelance.setFirstName(freelancer.getFirstName());
	freelance.setLastName(freelancer.getLastName());
	freelance.setEmailId(freelancer.getEmailId());
	freelance.setMobileNum(freelancer.getMobileNum());
	freelance.setSkills(freelancer.getSkills());
	freelance.setAddress(freelancer.getAddress());
	freelancerservice.updateFreelancer(freelance);
	HttpHeaders headers=new HttpHeaders();
	headers.add("desc","Updated Successfully");
	return ResponseEntity.ok().headers(headers).build();
}
}
