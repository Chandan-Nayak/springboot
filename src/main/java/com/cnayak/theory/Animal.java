package com.cnayak.theory;

public abstract class Animal extends Object{
	
	public String myName;
	private int legs=4;
	private String color;
	public static String year="2017";
	
	public Animal(){
		super();
		System.out.println("animal constructor");
	}
	
	public String bark(){
		return "barking";
	}
	
	public String eat(){
		return "eating";
	}
	
	private void breath(){
		System.out.println("breathing");
	}

}
