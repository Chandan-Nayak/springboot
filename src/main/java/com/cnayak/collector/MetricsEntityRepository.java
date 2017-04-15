package com.cnayak.collector;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface MetricsEntityRepository extends MongoRepository<MetricsEntity, String>{
    public List<MetricsEntity> findByname(String name);
//    public List<MetricesEntity> findByuniqueUnit(String uniqueUnit);

}
