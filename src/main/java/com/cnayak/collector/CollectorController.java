package com.cnayak.collector;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollectorController {
	
	@Autowired
	CollectorService collectorService;
	
	// Normal Routing methods with string
    @RequestMapping("/")
    Map<String,Map<String,String>> home() {
        return collectorService.welcome();
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/metrics")
	public MetricsEntity addTribe(@RequestBody MetricsEntity metrics) {
		return collectorService.saveOne(metrics);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/metrics")
	public List<MetricsEntity> getTribes() {
		return collectorService.getAll();
	}
	
	@RequestMapping("/metrics/{name}")
	public List<MetricsEntity> getTribe(@PathVariable String name){
		return collectorService.findByname(name);
	}
	
	@RequestMapping("/admin")
	public String getAdminAccess(){
		return "WelcomeAdmin";
	}

}
