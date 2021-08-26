package com.fwork.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.fwork.model.Work;
import com.fwork.services.WorkService;

@RestController
@RequestMapping("find-work")
public class WorkController {
	@Autowired
	WorkService workService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Work>> getAllWorks(){
			List<Work> workList = workService.allWork();
			HttpHeaders headers=new HttpHeaders();
			headers.add("desc","Getting all Works");
			return ResponseEntity.ok().headers(headers).body(workList);
	}
	
	@PostMapping("/addwork")
	public ResponseEntity<Work> addWork(@RequestBody Work work) {
		workService.addWork(work);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Work added Succcessfully");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
		
	}
	@GetMapping("/worktype/{type}")
	public ResponseEntity<List<Work>> getWorkByType(@PathVariable("type")String type) {
		List<Work> workList= workService.getByField(type);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Getting works by type");
		return ResponseEntity.ok().headers(headers).body(workList);
	}
	
	@GetMapping("/workdeal/{dealAmount}")
    public ResponseEntity<List<Work>> getWorkByAbovePrice(@PathVariable("dealAmount")double dealAmount)
    {
		List<Work> workList =workService.getWorkByAbovePrice(dealAmount);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Getting works by Aboce price");
		return ResponseEntity.ok().headers(headers).body(workList);
    }
	
	@GetMapping("/myworks/{id}/{status}")
	public ResponseEntity<List<Work>> getPostedWorksByStatus(@PathVariable("id") String id,@PathVariable("status") String status){
		List<Work> workList=workService.workStatusById(id, status);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Getting My works by status");
		return ResponseEntity.ok().headers(headers).body(workList);
	}
	
	@GetMapping("/myfreelanceworks/{id}/{status}")
	public ResponseEntity<List<Work>> getFreelanceWorksByStatus(@PathVariable("id") String id,@PathVariable("status") String status){
		List<Work> workList=workService.FreelanceWorkStatusById(id, status);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Getting My Freelance works by status");
		return ResponseEntity.ok().headers(headers).body(workList);
	}
	
	@DeleteMapping("/mywork/{id}")
	public ResponseEntity<Void> deleteWorkById(@PathVariable("id") int id){
		 workService.deleteWork(id);
			return ResponseEntity.ok().build();
	}
	@PatchMapping("/updatework/{id}")
	public ResponseEntity<Void> updateWorkById(@RequestBody Work work,@PathVariable("id") int id){
		Work nwork=workService.getWorkById(id);
		nwork.setWorkStatus(work.getWorkStatus());
		nwork.setDealAmount(work.getDealAmount());
		nwork.setDescription(work.getDescription());
		nwork.setDuration(work.getDuration());
		workService.updateWork(nwork);
		return ResponseEntity.ok().build();
	}
	@PatchMapping("/freelance/{workid}")
	public ResponseEntity<Void> freelancerWorkById(@RequestBody Work work,@PathVariable("workid") int workid){
		Work nwork=workService.getWorkById(workid);
		nwork.setFreelanceId(work.getFreelanceId());
		workService.updateWork(nwork);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/workbylocation/{location}")
	public ResponseEntity<List<Work>> getWorkByLocation(@PathVariable("location") String location){
		List<Work> workList=workService.getWorkByLocation(location);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Getting all works by location");
		return ResponseEntity.ok().headers(headers).body(workList);
	}

@GetMapping("/skill/{skills}")
public ResponseEntity<List<Work>> getWorkBySkills(@PathVariable("skills") List<String> skills){
	List<Work> workList = workService.getWorkBySkills(skills);
	HttpHeaders headers=new HttpHeaders();
	headers.add("desc", "Getting Works by Skills");
	return ResponseEntity.ok().headers(headers).body(workList);
}

}
