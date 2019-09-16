package com.practice.test.pct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Lab9 {

	private static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	private static HashMap<String, Integer> distmap = new HashMap<String, Integer>();
	private static ArrayList<String> visited = new ArrayList<String>();
	private static ArrayList<String> localpath = new ArrayList<String>();
	private static boolean isrecursionrequired = true;
	private static String start = null;
	private static int m_path = 200000;
	private static ArrayList<Integer> f_output = new ArrayList<Integer>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int edges = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < edges; i++) {
			String arr[] = sc.nextLine().split("\\s+");

			// String vertices[] = arr[0].toCharArray();

			creategraph(Character.toString(arr[0].charAt(0)), Character.toString(arr[0].charAt(1)),
					Integer.parseInt(arr[1]), arr[0]);

		}

		for (int j = 0; j < 1; j++) {
			String arr[] = sc.nextLine().split("\\s+");
			start = Character.toString(arr[0].charAt(0));
			m_path = 2000000;
			visited.clear();
			localpath.clear();
			DFS(Character.toString(arr[0].charAt(0)), Character.toString(arr[0].charAt(1)));
			f_output.add(m_path);
			// System.out.print(+" ");

		}
		for (int i = 0; i < f_output.size(); i++) {
			System.out.print(f_output.get(i) + " ");
		}

		// System.out.println(map);
		// System.out.println(distmap);
		// System.out.println(visited);
		// System.out.println(path);

	}

	private static void DFS(String source, String target) {

		visited.add(source);
		ArrayList<String> adjacentnodes = map.get(source);

		if (source.equals(target)) {
			System.out.println(localpath);

			int weight = distmap.get(start + localpath.get(0));

			for (int i = 0; i < localpath.size() - 1; i++) {
				weight = weight + distmap.get(localpath.get(i) + localpath.get(i + 1));

			}

			// m_path = weight;

			if (weight < m_path) {
				m_path = weight;
			}

			// System.out.println(m_path);
			// System.out.println(weight);
			visited.remove(source);
			return;
		}

		if (adjacentnodes != null) {
			for (String node : adjacentnodes) {

				if (!visited.contains(node)) {
					localpath.add(node);
					DFS(node, target);
					// if( isrecursionrequired = false)
					// {
					// return;
					// }
					localpath.remove(node);
					// localpath.clear();
				}

			}
		}
		
		 // Mark the current node 
		visited.remove(source);
	}

	private static void creategraph(String c, String d, int dist, String edge) {

		if (map.containsKey(c)) {
			map.get(c).add(d);

		} else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(d);
			map.put(c, list);

		}

		distmap.put(edge, dist);
		distmap.put(d + c, dist);

		if (map.containsKey(d)) {
			map.get(d).add(c);

		} else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(c);
			map.put(d, list);

		}

	}

}
