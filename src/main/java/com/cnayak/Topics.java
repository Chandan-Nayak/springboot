package com.cnayak;

public class Topics {

	private int id;
	private String Name;
	private String Description;

	public Topics() {

	}


	public Topics(int id, String name, String description) {
		super();
		this.id = id;
		Name = name;
		Description = description;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}




}
