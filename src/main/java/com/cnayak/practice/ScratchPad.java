package com.cnayak.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Sort;

import com.cnayak.theory.Dog;
import com.mongodb.client.model.Collation;

public class ScratchPad {

	public static void main(String[] args) {
		
		
		System.out.println("hello\n-----\n");
		
		System.out.println(Arrays.asList("sachin","sehwag","yuvraj"));
		
		String s = "";
		
		List l = new ArrayList<>();
		l.add("kohli");
		l.add("jadega");
		l.add("rahul");
		l.add("apple");
		System.out.println(">>>>>>>>>>>>>");
		System.out.println(l);
		Collections.sort(l);
		System.out.println(l);
		
		System.out.println("------------------");
		
		int[] test = {1,2,3,4,5};
		System.out.println(test[0]);
		
		
		
		
		
		
		
		
		
		
		

	}

}
