package com.practice.test.pct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Scanner;

public class Lab5_Again {

	public static void main(String[] args) {
		
	 Scanner sc = new Scanner(System.in);
	 LinkedHashSet<String> set = new LinkedHashSet<String>();
	 HashMap<Integer,String> map = new HashMap<Integer,String>();
	 String str = sc.nextLine();
	 String letter = sc.nextLine();
	 int minSize = 333333333;
	 
	 // generate all posibble substring
	 for (int i =0; i <str.length(); i++)
	 {
		  for (int j = i+1; j<=str.length();j++)
		  {
			 
			  set.add(str.substring(i, j));
			  
		  }	 		 
		 
	 }
	 
	 System.out.println(set);
	 
	 for (String s : set)
	 {
		 int subStringSize = getsize(s,letter);
		
		 
        if (subStringSize>0) {
			if(subStringSize < minSize) {
				minSize = subStringSize;
				map.put(minSize,s);
			}
	 }
	 }
	 
	 System.out.println(map.get(minSize));
	 
	}

	private static int getsize(String s, String letter) {
		int size = 0;
		int match = 0;
		
		StringBuffer sb = new StringBuffer(s);
		
		
		 for ( int j = 0 ; j<letter.length(); j++)
		 {   //take note of this syntax - very useful
			if ( sb.toString().contains(Character.toString(letter.charAt(j)))){
			
				int index = sb.toString().indexOf(letter.charAt(j));
				sb.deleteCharAt(index);
				match++;
			}
			
		 }
		
		if (match == letter.length())
		{
			size = s.length();
		}
		
		return size;
	}

}
