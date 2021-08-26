package com.fwork.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.fwork.model.Work;
@Repository
public interface WorkRepository extends MongoRepository<Work,Integer> {
	
    @Query("{$and:[{'type':/?0/},{'adminStatus':'approved'}]}")
	List<Work> findByField(String field);
    
    @Query("{$and:[{'dealAmount':{$gte:?0}},{adminStatus:'approved'}]}")
	List<Work> findWorkByAbovePrice(double deal);
    
    @Query("{$and:[{$or:[{'address.city':?0},{'address.state':?0},{'address.area':/?0/}]},{'adminStatus':'approved'}]}")
	List<Work> findworkByLocation(String location);
    
    @Query("{'userId':?0}")
	List<Work> findWorkByUserId(String id);
    
    @Query("{$and:[{'userId':?0},{'workStatus':?1},{'adminStatus':'approved'}]}")
	List<Work> findWorkStatusById(String id,String status);
    
    @Query("{$and:[{'freelanceId':?0},{'workStatus':?1},{'adminStatus':'approved'}]}")
	List<Work> findFreelancerWorkStatusById(String id, String status);
    
    @Query("{'skills':{$in:?0}}")
	List<Work> findBySkills(List<String> skills);
}
