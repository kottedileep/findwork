package com.fwork.services;

import java.util.List;

import com.fwork.exceptions.FreelancerNotFoundException;
import com.fwork.exceptions.WorkNotFoundException;
import com.fwork.model.Freelancer;
import com.fwork.model.Work;

public interface WorkService {
	public List<Work> getByField(String field) throws FreelancerNotFoundException;
	
	public List<Work> getWorkByAbovePrice(double deal) throws WorkNotFoundException;
	
	public List<Work> getWorkByLocation(String location) throws WorkNotFoundException;
	
	public void updateWork(Work work) throws WorkNotFoundException;
	
	public void deleteWork(int id) throws WorkNotFoundException;
	
	public Work addWork(Work work);
	
	public List<Work> allWork() throws WorkNotFoundException;
	
	public List<Work> workById(String id) throws WorkNotFoundException;
	
	public List<Work> workStatusById(String id,String status) throws WorkNotFoundException;
	
	public List<Work> FreelanceWorkStatusById(String id,String status) throws WorkNotFoundException;
	
	public void updateworkApproval(int id, String status);
	
	public Work getWorkById(int id) throws WorkNotFoundException;
	
	public List<Work> getWorkBySkills(List<String> skills) throws WorkNotFoundException;
	
}
