package com.practice.test.pct;

public class test1 {

	public static void main(String[] args) {
//		Animal animal = new Pig(); // Create a Pig object
//		animal.animalSound();
//		animal.sleep();
//		animal.extra();

		float f = 0f;
		
		f = 60/85;
		
		System.out.println(""+f);
		
		
	}

}

//Interface
interface Animal {
	public void animalSound(); // interface method (does not have a body)

	public void sleep(); // interface method (does not have a body)
	
	public void extra();
}

//Pig "implements" the Animal interface
class Pig implements Animal {
	public void animalSound() {
		// The body of animalSound() is provided here
		System.out.println("The pig says: wee wee");
	}

	public void sleep() {
		// The body of sleep() is provided here
		System.out.println("Zzz");
	}
	
	public void extra() {
		System.out.println("I am extra..");
	}
	
}

class MyMainClass {

}
