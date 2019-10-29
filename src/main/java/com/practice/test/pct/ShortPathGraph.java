package com.practice.test.pct;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ShortPathGraph {

	static LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
	static LinkedHashMap<String, Integer> distmap = new LinkedHashMap<String, Integer>();
	static ArrayList<String> localpath = new ArrayList<String>();
	static int min_path = Integer.MAX_VALUE;
	static ArrayList<String> visited = new ArrayList<String>();
    static ArrayList<Integer> f_path = new ArrayList<Integer>();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numberOfEdges = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < numberOfEdges; i++) {

			String arr[] = sc.nextLine().split("\\s+");
			String a = Character.toString(arr[0].charAt(0));
			String b = Character.toString(arr[0].charAt(1));
			int dist = Integer.parseInt(arr[1]);
			creategraph(a, b, dist);

		}

		//System.out.println(map);
		//System.out.println(distmap);
		
		for (int i = 0; i < 5; i++) {

			String arr = sc.nextLine();
			String source = Character.toString(arr.charAt(0));
			String destination = Character.toString(arr.charAt(1));
			min_path = Integer.MAX_VALUE;
			localpath.clear();
			localpath.add(source);
			DFS(source, destination);
            f_path.add(min_path);
		}

		
		for (int i = 0; i<f_path.size();i++) {
			
		  System.out.print(f_path.get(i)+" ");
		  
		}
		//System.out.print(f_path.get(f_path.size()-1)+" ");
	}

	private static void DFS(String source, String destination) {

		visited.add(source);

		if (source.equals(destination)) {

			int total = 0;
			//System.out.println(localpath);
			for (int i = 0; i < localpath.size() - 1; i++) {

				String a = localpath.get(i);
				String b = localpath.get(i + 1);
				String key = a + b;
				if (distmap.containsKey(key)) {
					int dist = distmap.get(key);
					total = dist + total;
				}

			}
			min_path = Math.min(min_path, total);
			visited.remove(source);
			return;
		}

		ArrayList<String> adjacentNodes = map.get(source);

		if (adjacentNodes != null) {

			for (String adjcentNode : adjacentNodes) {

				if (!visited.contains(adjcentNode)) {

					localpath.add(adjcentNode);
					DFS(adjcentNode, destination);
					localpath.remove(adjcentNode);
				}

			}

		}

		visited.remove(source);
	}

	private static void creategraph(String a, String b, int dist) {

		if (map.containsKey(a)) {
			map.get(a).add(b);
		} else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(b);
			map.put(a, list);
		}

		if (map.containsKey(b)) {
			map.get(b).add(a);
		} else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(a);
			map.put(b, list);
		}

		distmap.put(a + b, dist);
		distmap.put(b + a, dist);

	}

}
