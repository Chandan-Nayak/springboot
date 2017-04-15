package com.cnayak.theory;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGui1 {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton button = new JButton("Click Here");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(button);
		frame.setSize(100, 100);
		frame.setVisible(true);
		
		
	}

}
