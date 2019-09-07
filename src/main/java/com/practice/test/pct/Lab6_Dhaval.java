package com.practice.test.pct;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Iterator;

public class Lab6_Dhaval {

	private static int component;
	
	static ArrayList<String> visited = new ArrayList<String>();
	static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
        
		

		for (int i = 0; i < edges; i++) {
			String[] arr = sc.nextLine().split("\\s");
			creatgraph(arr[0], arr[1], map);

		}
		
		 component = 0;
		 Iterator<Entry<String, ArrayList<String>>> itr = map.entrySet().iterator();
		 
		 while(itr.hasNext())
		 {
		   Map.Entry pair  =  (Map.Entry)itr.next();	
		   
		   String str = (String) pair.getKey();
			 
		    if (!visited.contains(str))	
		    {
		    	DFS(str);
		    	component++;
		    	
		    }
			 
			 
		 }
		 
	   int diff = vertices - visited.size();
		 
	   component+= diff; 
		
	   if (component > 1)
	   {
		 System.out.println("0"+ " " +component);   
		   
		   
	   }
	   else
	   {
		 System.out.println("1"+ " " +component);   
		   
		   
	   }
	 

		sc.close();

	}

	private static  void DFS(String str) {
		
		visited.add(str);
	    ArrayList<String> values = map.get(str);
	    
	    ListIterator<String> itr = values.listIterator();
	    
	    while(itr.hasNext())
	    {
	       	
	     String str1 = itr.next();	
	    if (!visited.contains(str1))
	    {
	    	DFS(str1);
	    	
	    }
	    
	    
	    }
	    
		
		
	}

	private static void creatgraph(String a, String b, HashMap<String, ArrayList<String>> map) {

		if (map.containsKey(a)) {
			ArrayList<String> list = map.get(a);
			list.add(b);
			map.put(a, list);
		} else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(b);
			map.put(a, list);
		}
		
		if (map.containsKey(b)) {
			ArrayList<String> list = map.get(b);
			list.add(a);
			map.put(b, list);
		} else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(a);
			map.put(b, list);
		}

	}
}
