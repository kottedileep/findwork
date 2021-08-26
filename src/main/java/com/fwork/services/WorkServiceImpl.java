package com.fwork.services;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwork.exceptions.WorkNotFoundException;

import com.fwork.model.Work;
import com.fwork.repository.WorkRepository;
@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	WorkRepository workRepository;
	@Override
	public List<Work> getByField(String field) throws WorkNotFoundException {
		List<Work> nwork=workRepository.findByField(field);
		if(nwork.isEmpty()) {
			throw new WorkNotFoundException("No Works Available in this type");
		}
		return nwork;
	}
	
	@Override
	public List<Work> getWorkByAbovePrice(double deal) throws WorkNotFoundException {
		List<Work> nwork = workRepository.findWorkByAbovePrice(deal);
		if(nwork.isEmpty()) {
			throw new WorkNotFoundException("No Works Available in this type");
		}
		return nwork;
	}
	
	@Override
	public List<Work> getWorkByLocation(String location) throws WorkNotFoundException {
		List<Work> nwork=workRepository.findworkByLocation(location);
		if(nwork.isEmpty()) {
			throw new WorkNotFoundException("No Works Available in this type");
		}
		return nwork;
		
	}
	
	@Override
	public void updateWork(Work workData) throws WorkNotFoundException {	
		workRepository.save(workData);
	}

	@Override
	public void deleteWork(int id) throws WorkNotFoundException {
		workRepository.deleteById(id);
	}

	@Override
	public Work addWork(Work work) {
	
		Work nwork=workRepository.insert(work);
		return nwork;
	}
	@Override
	public List<Work> allWork() throws WorkNotFoundException {
	
		List<Work> nwork= workRepository.findAll();
		if(nwork.isEmpty()) {
			throw new WorkNotFoundException("No Work is available");
		}
		return nwork;
	}

	@Override
	public List<Work> workById(String id) throws WorkNotFoundException {
		List<Work> nwork = workRepository.findWorkByUserId(id);
		if(nwork.isEmpty()) {
			throw new WorkNotFoundException("No Works are not available");
		}
		return nwork;
	}

	@Override
	public List<Work> workStatusById(String id,String status) throws WorkNotFoundException {

		List<Work> nwork=workRepository.findWorkStatusById(id,status);
		if(nwork.isEmpty()) {
			throw new WorkNotFoundException("No works are completed till now");
		}
		return nwork;
	}



	@Override
	public List<Work> FreelanceWorkStatusById(String id,String status) throws WorkNotFoundException {
        List<Work> nwork=workRepository.findFreelancerWorkStatusById(id,status);
        if(nwork.isEmpty()) {
        	throw new WorkNotFoundException("No works are available");
        }
        return nwork;
	}
	@Override
	public void updateworkApproval(int id, String status) {
		Optional<Work> nwork=workRepository.findById(id);
		Work work=nwork.get();
		work.setAdminStatus(status);
		workRepository.save(work);
	}
	@Override
	public Work getWorkById(int id) throws WorkNotFoundException {
		Optional<Work> work=workRepository.findById(id);
		return work.get();
	}

	@Override
	public List<Work> getWorkBySkills(List<String> skills) throws WorkNotFoundException {
		List<Work> nwork=workRepository.findBySkills(skills).stream().filter(work->work.getSkills().containsAll(skills)).collect(Collectors.toList());
		if(nwork.isEmpty()) {
			throw new WorkNotFoundException("No Works are available with this skills");
		}
		return nwork;      
	}

}
