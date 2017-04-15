package com.cnayak;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntityRepository extends MongoRepository<Entity, String>{
	
    public Entity findBytribeName(String tribeName);
    public List<Entity> findByuniqueUnit(String uniqueUnit);
    

}
