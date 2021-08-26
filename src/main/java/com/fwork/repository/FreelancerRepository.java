package com.fwork.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.fwork.model.Freelancer;
@Repository
public interface FreelancerRepository extends MongoRepository<Freelancer,String> {
@Query("{'firstName':{'$regex': /?0/,'$options':'i'}}")
List<Freelancer> findByFirstName(String name);
@Query("{'skills':{$in:?0}}")
List<Freelancer> findBySkills(List<String> requiredskill);
@Query("{$or:[{'address.city':?0},{'address.State':?0},{'address.area':/?0/}]}")
List<Freelancer> findByLocation(String location);
@Query("{$and:[{'skills':{$in:/?0/}},{$or:[{'address.city':?1},{'address.State':?1},{'address.area':/?1/}]}]}")
List<Freelancer> findBySkillsAndLocation(List<String> requiredskill, String location);
}
