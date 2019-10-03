package com.practice.test.pct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*

input
4
3
1 0
1 2
1 3

output
[1]

input
6
5
0 3
1 3
2 3
4 3
5 4

output
[3, 4]

*/
public class Find_Nodes_Minimum_Height_Tree {

	static ArrayList<String> listleaf = new ArrayList<String>();
	static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < edges; i++) {
			String[] arr = sc.nextLine().split("\\s");
			creatgraph(arr[0], arr[1], map);

		}
		
		
		findleaf();
		listleaf = getMHT(vertices);
		
		System.out.println(listleaf);
		sc.close();
		
	}
	private static ArrayList<String> getMHT(int vertices) {
		
		while(vertices >2 )
		{
			vertices = vertices - listleaf.size();
			
			removeleaf();
			
			findleaf();
			
		}
		
		
		return listleaf;
	}
	
	
	private static void removeleaf() {
	
		
			  for (String leaf : listleaf)
			  {
				  ArrayList<String> list = map.get(leaf);
				  map.remove(leaf);
				  map.get(list.get(0)).remove(leaf);
				  
				  
			  }
			
		listleaf.clear();
		
	}
	private static void findleaf() {
		
		for (Entry<String,ArrayList<String>> entry : map.entrySet())
		{
			if (entry.getValue().size() == 1 || entry.getValue().size() == 0)
			{
				listleaf.add(entry.getKey());
				
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