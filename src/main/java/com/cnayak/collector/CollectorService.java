package com.cnayak.collector;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

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
	
	
	public Map<String,Map<String,String>> welcome(){
		
		String name = "chandan nayak";
		
		Map<String, Map<String, String>> l = new LinkedHashMap<String,Map<String,String>>();
		Map<String,String> startupMessage = new LinkedHashMap<String,String>();
		Map<String,String> metricsEndpointMessage = new LinkedHashMap<String,String>();
		Map<String,String> tribeEndpointMessage = new LinkedHashMap<String,String>();
		
		startupMessage.put("greetings", "WELCOME!");
		startupMessage.put("name",name);
		startupMessage.put("time", getTime());
		
		tribeEndpointMessage.put("01 - /tribes","GET");
		tribeEndpointMessage.put("02 - /tribes/{name}","GET");
		tribeEndpointMessage.put("03 - /tribes","POST");
		tribeEndpointMessage.put("04 - /tribes/{name}","PUT");
		tribeEndpointMessage.put("05 - /deleteAll","GET");
		
		metricsEndpointMessage.put("01 - /metrics", "GET");
		metricsEndpointMessage.put("02 - /metrics/{cpu/memory}", "GET");
		metricsEndpointMessage.put("03 - /metrics", "POST");

		l.put("startup", startupMessage);
		l.put("tribe-endpoint", tribeEndpointMessage);
		l.put("metrics-endpoint", metricsEndpointMessage);
		return l;
		
	}
	
	private String getTime(){
		SimpleDateFormat sd = new SimpleDateFormat(
				"yyyy.MM.dd G 'at' HH:mm:ss z");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		return sd.format(date).toString();
	}

}
