package com.practice.test.pct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab5_Dhaval {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine().trim();
		String letter = sc.nextLine().trim();
		
		String shortstring = null;

		if (str.equals(letter)) {
			System.out.println("Shortest Window" + str);
		} else {

			List<String> list = new ArrayList<String>();

			for (int i = 0; i < str.length(); i++) {

				for (int j = i + 1; j < str.length(); j++) {
					String substr = str.substring(i, j);
					int count = 0;
					if (substr.length() >= letter.length()) {

						for (int k = 0; k < letter.length(); k++) {
							

							if (substr.contains(Character.toString(letter.charAt(k)))) {

								count++;

							}

						}
						
						
				       if (count == letter.length())
				       {
				    	   list.add(substr);  
				    	   
				       }
				       
				       }
				    	   
						
						

					}

				shortstring =  list.get(0);
				for (int l = 1 ; l < list.size(); l++)
				{
					
					String temp  =  list.get(l);
					
					if (temp.length()<= shortstring.length())
					{
						shortstring = temp;
					   
						
					}
						
					
					
				}
				
				
				
				
				
				}
			System.out.println("Shortest Window" + " " +shortstring);

			}
		sc.close();
		}

		//sc.close();

	}

