package com.cnayak.collector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectorService {
	
	@Autowired
	private MetricsEntityRepository mongodb;
	
	public List<MetricsEntity> getAll(){
		return mongodb.findAll();
	}

	public MetricsEntity saveOne(MetricsEntity metrics) {
		return mongodb.save(metrics);
	}

	public List<MetricsEntity> findByname(String name) {
		return mongodb.findByname(name);
	}

}
