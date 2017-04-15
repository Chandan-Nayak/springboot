package com.cnayak.collector;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "metrics")
public class MetricsEntity {
	
	@Id
	public String time;
	
	public String name;
	public ArrayList<String> metrics;
	
	public MetricsEntity(){
		
	}

	public MetricsEntity(String time, String name, ArrayList<String> metrics) {
		super();
		this.time = time;
		this.name = name;
		this.metrics = metrics;
	}
	
	
	
	

}
