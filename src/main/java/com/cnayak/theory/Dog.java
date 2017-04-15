package com.cnayak.theory;

public class Dog extends Animal{
	
	
	private String name = "Dog";
	
	
	public static void main(String[] args) {
		Animal a = new Dog();
		a.myName =  "dog";
		System.out.println(a.myName);
		System.out.println(a.year);
		a.year = "2018";
		
		Animal b = new Dog();
		System.out.println(b.myName);
		System.out.println(b.year);
		
		System.out.println(year);
		
		System.out.println(Math.round(42.2));
		
		System.out.println("------------");
		int i = 5;
		Integer z = new Integer(i);
		System.out.println(z.getClass().getSimpleName());
		
		
		
	}
}
