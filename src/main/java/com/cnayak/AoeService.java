package com.cnayak;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AoeService {

	@Autowired
	private EntityRepository mongodb;
	

	public Entity hardSave(Entity entity) {
		return mongodb.save(entity);

	}

	public List<Entity> fetchAll() {
		return mongodb.findAll();
	}

	public String cleanDb() {
		mongodb.deleteAll();
		return "deleted";
	}

	public Entity saveOne(Entity tribe) {
		return mongodb.save(tribe);
	}

	public Entity findBytribeName(String name) {
		return mongodb.findBytribeName(name);
	}

	public Entity updateOne(Entity tribe) {
		return mongodb.save(tribe);
	}


}
