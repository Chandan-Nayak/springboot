package com.cnayak;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	EntityRepository entityRepository;
	
	@Autowired
	TopicService topicService; 
	
	@Autowired
	AoeService aoeService;
	
	
	// Normal Routing methods with string
    @RequestMapping("/")
    String home() {
        return "Hello World! - Keep Coming Back";
    }

	@RequestMapping(method=RequestMethod.GET, value="/name")
	String name() {
		return "Chandan";
	}
	
	
	// Using service methods here hard coded 
	@RequestMapping("/topics")
	public List<Topics> getAllTopics(){
		return topicService.getTopics();
	}
	
	@RequestMapping("/topics/{name}")
	public Topics getTopic(@PathVariable String name){
		return topicService.getTopic(name);
	}
	
	
	// Using entity routes here mongo db
	@RequestMapping("/hardSave")
	public Entity save() {
		return aoeService.hardSave(new Entity ("huns","tarakans"));
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/tribes")
	public Entity addTribe(@RequestBody Entity tribe) {
		return aoeService.saveOne(tribe);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/tribes")
	public Entity updateTribe(@RequestBody Entity tribe) {
		return aoeService.updateOne(tribe);
	}
	
	@RequestMapping("/tribes")
	public List<Entity> fetchAll() {
		return aoeService.fetchAll();
	}
	
	@RequestMapping("/tribes/{name}")
	public Entity getTribe(@PathVariable String name){
		return aoeService.findBytribeName(name);
	}
	
	
	
	@RequestMapping("/deleteAll")
	public String delete() {
		return aoeService.cleanDb();
	}
	
}
