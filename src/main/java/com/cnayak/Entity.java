package com.cnayak;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "collectionname")
public class Entity {
	
	   @Id
	    public String id;
	   
	    public String tribeName;
	    public String uniqueUnit;

	    public Entity() {}

	    public Entity(String tribeName, String uniqueUnit) {
	        this.tribeName = tribeName;
	        this.uniqueUnit = uniqueUnit;
	    }
	    
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}

//	    @Override
//	    public String toString() {
//	        return String.format(
//	                "Customer[id=%s, firstName='%s', lastName='%s']",
//	                id, tribeName, lastName);
//	    }

}
