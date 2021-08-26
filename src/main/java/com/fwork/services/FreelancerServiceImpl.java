package com.fwork.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwork.exceptions.FreelancerNotFoundException;
import com.fwork.model.Freelancer;
import com.fwork.repository.FreelancerRepository;
@Service
public class FreelancerServiceImpl implements FreelancerService{
	@Autowired
    FreelancerRepository freelancerRepository;
	@Override
	public Freelancer getByFreelanceId(String id) throws FreelancerNotFoundException {
		Optional<Freelancer> freelance = freelancerRepository.findById(id);
		return freelance.get();
	}

	@Override
	public List<Freelancer> getByFreelanceName(String name) throws FreelancerNotFoundException {
		List<Freelancer> nfreelancer= freelancerRepository.findByFirstName(name);
		if(nfreelancer.isEmpty()) {
			throw new FreelancerNotFoundException("No Freelancers");
		}
		return nfreelancer;
	}

	@Override
	public List<Freelancer> getBySkill(List<String> requiredskill) throws FreelancerNotFoundException {
		List<Freelancer> nfreelancer=freelancerRepository.findBySkills(requiredskill).stream().filter(freelancer->freelancer.getSkills().containsAll(requiredskill)).collect(Collectors.toList());
		if(nfreelancer.isEmpty()) {
			throw new FreelancerNotFoundException("No Freelancers with the skills");
		}
		return nfreelancer;
	}

	@Override
	public List<Freelancer> getByLocation(String location) throws FreelancerNotFoundException {
		List<Freelancer> nfreelancer=freelancerRepository.findByLocation(location);
		if(nfreelancer.isEmpty()) {
			throw new FreelancerNotFoundException("No Freelancers in the city");
		}
		return nfreelancer;
	}

	@Override
	public List<Freelancer> getBySkillsAndLocation(List<String> requiredskill, String location)
			throws FreelancerNotFoundException {
		List<Freelancer> nfreelancer=freelancerRepository.findBySkillsAndLocation(requiredskill,location).stream().filter(freelancer->freelancer.getSkills().containsAll(requiredskill)).collect(Collectors.toList());
		if(nfreelancer.isEmpty()) {
			throw new FreelancerNotFoundException("No Freelancers with the skills");
		}
		return nfreelancer;
	}

	@Override
	public List<Freelancer> allFreelancer() {
		return freelancerRepository.findAll();

	}

	@Override
	public Freelancer addFreelancer(Freelancer freelancer) {
		Freelancer freelance=freelancerRepository.insert(freelancer);
		return freelance;
	}

	@Override
	public void updateFreelancer(Freelancer freelancer) {
		freelancerRepository.save(freelancer);
		
	}


}
