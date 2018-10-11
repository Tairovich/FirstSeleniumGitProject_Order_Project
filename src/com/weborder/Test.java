package com.weborder;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		
		
		Random r = new Random();
		int random = r.nextInt(23-18) + 18;
		System.out.println(random);
		
		String str = "abcdefghijklmnopqrstuvwxyz";
		String name = "";
		for (int i = 0; i < 7; i++) {
			name += str.charAt( r.nextInt(str.length()));
		}
		System.out.println(name);
		
		String zip = "";
		for (int i = 0; i < 5; i++) {
			zip += Integer.valueOf( r.nextInt( 10-1) + 1);
		}
		System.out.println(zip);
		
		System.out.println(ran());
		
	}
	
	public static String ran () {
		String num = "";
		Random r = new Random();
		for (int i = 0; i < 15; i++) {
			num += r.nextInt(10-1) + 1;
		}
		return num;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
