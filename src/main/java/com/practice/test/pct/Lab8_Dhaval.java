package com.practice.test.pct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Lab8_Dhaval {

	private static HashMap<String, ArrayList<String>> originalmap = new HashMap<String, ArrayList<String>>();
	private static HashMap<String, ArrayList<String>> transposemap = new HashMap<String, ArrayList<String>>();
	private static ArrayList<String> visitedoriginal = new ArrayList<String>();
	private static ArrayList<String> visitedtranspose = new ArrayList<String>();
	private static Stack<String> s = new Stack<String>();
	private static ArrayList<String> component = new ArrayList<String>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < edges; i++) {
			String arr[] = sc.nextLine().split("\\s+");

			creategraph(arr[0], arr[1]);
			transposegraph(arr[1], arr[0]);
		}

		Iterator itr = originalmap.entrySet().iterator();

		while (itr.hasNext()) {
			Map.Entry<String, ArrayList<String>> entry = (Map.Entry<String, ArrayList<String>>) itr.next();

			String str = entry.getKey();
			if (!visitedoriginal.contains(str)) {
				DFS(str);

			}

		}

		while (s.size() != 0) {
			String src = s.pop();
			component.clear();
			if (!visitedtranspose.contains(src)) {
				DFSTran(src);
				Collections.sort(component);
				System.out.println(component);

			}

		}

	}

	private static void DFSTran(String src) {
		visitedtranspose.add(src);
		component.add(src);
		ArrayList<String> list = transposemap.get(src);

		if (list != null) {
			ListIterator<String> itr = list.listIterator();

			while (itr.hasNext()) {
				String str1 = (String) itr.next();

				if (!visitedtranspose.contains(str1)) {
					DFSTran(str1);

				}

			}

		}
	}

	private static void DFS(String str) {

		visitedoriginal.add(str);
		ArrayList<String> list = originalmap.get(str);

		if (list != null) {
			ListIterator<String> itr = list.listIterator();
			while (itr.hasNext()) {
				String str1 = (String) itr.next();

				if (!visitedoriginal.contains(str1)) {
					DFS(str1);

				}

			}

		}
		s.push(str);

	}

	private static void transposegraph(String a, String b) {

		if (transposemap.containsKey(a)) {

			ArrayList<String> list = transposemap.get(a);
			list.add(b);
			transposemap.put(a, list);
		}

		else {

			ArrayList<String> list = new ArrayList<String>();
			list.add(b);
			transposemap.put(a, list);

		}

	}

	private static void creategraph(String a, String b) {

		if (originalmap.containsKey(a)) {

			ArrayList<String> list = originalmap.get(a);
			list.add(b);
			originalmap.put(a, list);
		}

		else {

			ArrayList<String> list = new ArrayList<String>();
			list.add(b);
			originalmap.put(a, list);

		}

	}

}
