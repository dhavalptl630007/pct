package com.practice.test.pct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Lab9_Again {

	private static HashMap<String, ArrayList<String>> graphmap = new HashMap<String, ArrayList<String>>();
	private static HashMap<String, Integer> distmap = new HashMap<String, Integer>();
	private static ArrayList<String> visited = new ArrayList<String>();
	private static ArrayList<String> localpath = new ArrayList<String>();
	private static ArrayList<Integer> f_output = new ArrayList<Integer>();
	private static String start = "";
	private static Integer weight;
	private static Integer m_path;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n_edge = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n_edge; i++) {
			String[] arr = sc.nextLine().split("\\s+");

			creategraph(Character.toString(arr[0].charAt(0)), Character.toString(arr[0].charAt(1)), arr[0],
					Integer.parseInt(arr[1]));
		}

		// System.out.println(graphmap);
		// System.out.println(distmap);

		for (int i = 0; i < 5; i++) {

			String arr = sc.nextLine();

			start = Character.toString(arr.charAt(0));
			visited.clear();
			localpath.clear();
			weight = 0;
			m_path = 999999999;
			DFSforshortpath(Character.toString(arr.charAt(0)), Character.toString(arr.charAt(1)));
			f_output.add(m_path);

		}
		String s = "";
		for (int i = 0; i < f_output.size(); i++) {
		//	System.out.println(f_output.get(i)+ " ");
			s= s+ " " + f_output.get(i);
		}

		System.out.println(s.trim());
		sc.close();

	}

	private static void DFSforshortpath(String source, String target) {

		visited.add(source);

		if (source.equals(target)) {

			weight = distmap.get(start + localpath.get(0));

			for (int i = 0; i < localpath.size()-1; i++) {
				
				String edge = localpath.get(i) + localpath.get(i + 1);
				if (distmap.containsKey(edge)) 
				weight = weight + distmap.get(edge);
				//weight = weight + distmap.get(localpath.get(i));
			}

			if (m_path > weight) {
				m_path = weight;
			}

			visited.remove(source);
     		return;  // very important
		}

		ArrayList<String> adjacenNodes = graphmap.get(source);
		if (adjacenNodes != null) {

			for (String node : adjacenNodes) {
				if (!visited.contains(node)) {
					localpath.add(node);
					DFSforshortpath(node, target);
					localpath.remove(node);
				}
			}

		}

		visited.remove(source);
	}

	private static void creategraph(String a, String b, String edge, int dist) {

		if (graphmap.containsKey(a)) {
			graphmap.get(a).add(b);
		}

		else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(b);
			graphmap.put(a, list);
		}

		if (graphmap.containsKey(b)) {
			graphmap.get(b).add(a);
		}

		else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(a);
			graphmap.put(b, list);
		}

		distmap.put(edge, dist);
		distmap.put(b + a, dist);

	}

}
