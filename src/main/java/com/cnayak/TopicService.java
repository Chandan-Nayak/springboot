package com.cnayak;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topics> topics = Arrays.asList(new Topics(1,"js","javascript"),
			new Topics(2,"cpp","c++"),
			new Topics(3,"aws","amazon web services")
			);

	public List<Topics> getTopics() {
		return topics;
	}
	
	public Topics getTopic(String name){
		return topics.stream().filter(t -> t.getName().equals(name)).findFirst().get();
	}
	
	
	

}
