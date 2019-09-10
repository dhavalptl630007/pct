package com.practice.test.pct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Lab10_Dhaval {

	private static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	private static boolean flag;
	private static ArrayList<String> result = new ArrayList<String>();
	private static ArrayList<String> visited = new ArrayList<String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String src = null;
		String target = null;
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < edges; i++) {
			String arr[] = sc.nextLine().split("\\s+");
			creategraph(arr[0], arr[1]);

		}

		int testinput = Integer.parseInt(sc.nextLine());

		for (int j = 0; j < testinput; j++) {

			String arr[] = sc.nextLine().split("\\s+");
			src = arr[0];
			target = arr[1];

			checkpath(src, target);
			if (flag == true) {

				result.add("YES");

			} else {
				result.add("NO");
			}
		}

		for (int i = 0; i < result.size(); i++) {

			System.out.print(result.get(i) + " ");

		}

		sc.close();

	}

	private static void checkpath(String src, String target) {

	flag = false;	
//	 LinkedList<String> list = new 	LinkedList<String>();
//	 
//	 list.add(src);
//	 
//	 src = list.poll();
//	 
//	 if(list!=null)
//	 {
//	   Iterator itr = list.listIterator();
//	   
//	   while(itr.hasNext())
//	   {
//		   
//		String dest = (String) itr.next();
//		
//		if (dest.equals(target)) 
//		{
//		   flag = true;			
//		}
//		
//		else
//		{
//			
//			ArrayList 
//			
//			if(!visited.contains(dest))
//			{
//				visited.add(dest);
//				list.add(dest);
//				
//			}
//			
//			
//		}
//		
//		   
//	   } 
//		 
//		 
//	 }
		 visited.add(src);	 
		ArrayList<String> list = map.get(src);

		ListIterator<String> itr = list.listIterator();

		while (itr.hasNext()) {
			String str = (String) itr.next();

			if (str.equals(target)) {
				
			    flag = true;
				return;

			} else {
				
				 if(!visited.contains(str))
				 {
				 
				 DFS(str, target);
				 }
				 
				  
			}
		}
        
	

	}

	private static void DFS(String src, String target) {
		
		visited.add(src);
		ArrayList<String> list = map.get(src);

		ListIterator<String> itr = list.listIterator();

		while (itr.hasNext()) {
			String str1 = (String) itr.next();

			if (str1.equals(target)) {
				flag = true;
                 return;
			} else {
				
				 if(!visited.contains(str1))
				 {
				 
				 DFS(str1, target);
				 }
				 
				 //return false; 
			}
		
		}
	}

	private static void creategraph(String a, String b) {

		if (map.containsKey(a)) {

			ArrayList<String> list = map.get(a);
			list.add(b);
			map.put(a, list);
		} else {

			ArrayList<String> list = new ArrayList<String>();
			list.add(b);
			map.put(a, list);

		}

	}

}
