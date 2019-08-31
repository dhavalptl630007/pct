package com.practice.test.pct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pct_practice_1 {

	public static void main(String arg[]) {

		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();

		int numberOfPlayers = Integer.parseInt(Character.toString(line.charAt(0)));

		List<BasketBall> bl = new ArrayList<BasketBall>();

		int maxPPM = 0;
		String maxPPMName = null;

		for (int i = 0; i < numberOfPlayers; i++) {

			BasketBall bb = new BasketBall();

			bb.setName(sc.nextLine());
			bb.setOnePointers(Integer.parseInt(sc.nextLine()));
			bb.setTwoPointers(Integer.parseInt(sc.nextLine()));
			bb.setThreePointers(Integer.parseInt(sc.nextLine()));
			bb.setNumberOfMinutes(Integer.parseInt(sc.nextLine()));

			bl.add(bb);

			if (bb.calculatePPM() > maxPPM) {
				maxPPM = bb.calculatePPM();
				maxPPMName = bb.getName();
			}

		}

		System.out.println(maxPPMName + " " + maxPPM);

		sc.close();
		
	}

}

class BasketBall {

	String name;
	int onePointers;
	int twoPointers;
	int threePointers;
	int numberOfMinutes;

	int pointPerMinute;

	public int calculatePPM() {

		float sumpoints = onePointers + (twoPointers * 2) + (threePointers * 3);
		
		float ppm = (sumpoints/numberOfMinutes)*1000;
		
		
		System.out.println("ppm of - "+name+ppm);
		
		return (int) Math.round(ppm);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOnePointers() {
		return onePointers;
	}

	public void setOnePointers(int onePointers) {
		this.onePointers = onePointers;
	}

	public int getTwoPointers() {
		return twoPointers;
	}

	public void setTwoPointers(int twoPointers) {
		this.twoPointers = twoPointers;
	}

	public int getThreePointers() {
		return threePointers;
	}

	public void setThreePointers(int threePointers) {
		this.threePointers = threePointers;
	}

	public int getNumberOfMinutes() {
		return numberOfMinutes;
	}

	public void setNumberOfMinutes(int numberOfMinutes) {
		this.numberOfMinutes = numberOfMinutes;
	}

}
