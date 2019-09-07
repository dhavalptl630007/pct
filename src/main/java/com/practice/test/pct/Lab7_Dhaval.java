package com.practice.test.pct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class node2 {
	String data;
	node2 left, right;

	node2(String data) {
		this.data = data;
		left = null;
		right = null;

	}

}

public class Lab7_Dhaval {

	private static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	private static boolean flag;
	private static ArrayList<String> childlist = new ArrayList<String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		ArrayList<String> dataset = new ArrayList<String>();
		ArrayList<String> relation = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			dataset.add(str);

			String[] arr = str.split("\\s+");

			createmap(arr[0], arr[1], map);

		}

		String[] arr = dataset.get(0).split("\\s+");

		// root.data = dataset.get(arr[0]);

		node2 root = new node2(arr[0]);

		createtree(root, map);

//		
		int m = Integer.parseInt(sc.nextLine()); // sc.nextInt();
		// System.out.println(m);
		for (int i = 0; i < m; i++) {

			String str1 = sc.nextLine();
			relation.add(str1);

			String arr1[] = str1.split("\\s+");

			if (arr1[1].equals("child")) {
				flag = checkchild(arr1[0], arr1[2], map);
				if (flag == true) {
					result.add("T");
				} else {
					result.add("F");
				}
			} else if (arr1[1].equals("sibling")) {
				flag = checksibling(arr1[0], arr1[2], map);

				if (flag == true) {
					result.add("T");
				} else {
					result.add("F");
				}
			}

			else if (arr1[1].equals("ancestor")) {

				childlist.clear();
				checkancestor(root, arr1[0], arr1[2], childlist);
				if (childlist.contains(arr1[2])) {
					result.add("T");
				} else {
					result.add("F");
				}
			}

			else if (arr1[1].equals("descendant")) {

				childlist.clear();
				checkancestor(root, arr1[2], arr1[0], childlist);
				if (childlist.contains(arr1[0])) {
					result.add("T");
				} else {
					result.add("F");
				}
			}

		}

		preorder(root);
		System.out.println();

		for (int j = 0; j < result.size(); j++) {
			System.out.print(result.get(j));

		}

		sc.close();
	}

	private static void checkancestor(node2 root, String ansector, String target, ArrayList<String> childlist) {

		if (root == null) {
			return;
		}

		if (root.data.equals(ansector)) {
			checkanc1(root, childlist);
			return;

		}

		checkancestor(root.left, ansector, target, childlist);
		checkancestor(root.right, ansector, target, childlist);

	}

	private static void checkanc1(node2 root, ArrayList<String> childlist) {

		if (root == null) {
			return;
		}
		childlist.add(root.data);
		checkanc1(root.left, childlist);
		checkanc1(root.right, childlist);

	}

	private static boolean checksibling(String sb1, String sb2, HashMap<String, ArrayList<String>> map) {

		Iterator itr = map.entrySet().iterator();

		while (itr.hasNext()) {
			Map.Entry pair = (Map.Entry) itr.next();

			String key1 = (String) pair.getKey();
			ArrayList<String> list = (ArrayList<String>) pair.getValue();

			if (list.contains(sb1) && list.contains(sb2)) {

				return true;
			} else {
				flag = false;
			}

		}
		return flag;

	}

	private static boolean checkchild(String child, String parent, HashMap<String, ArrayList<String>> map2) {

		if (!map.containsKey(parent)) {
			return false;
		}

		else {
			ArrayList<String> list = map.get(parent);

			if (list.contains(child)) {
				return true;

			} else {
				return false;
			}
		}

	}

	private static void preorder(node2 root) {

		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);

	}

	private static void createtree(node2 root, HashMap<String, ArrayList<String>> map) {

		if (root == null) {
			return;
		}
		if (map.containsKey(root.data)) {
			List<String> child = map.get(root.data);
//		   node leftnode = new leftnode();

			if (child.size() == 1) {
				node2 leftnode = new node2(child.get(0));
				root.left = leftnode;

			} else {

				node2 leftnode = new node2(child.get(0));
				node2 rightnode = new node2(child.get(1));
				root.left = leftnode;
				root.right = rightnode;

			}

			createtree(root.left, map);
			createtree(root.right, map);
		}
	}

	private static void createmap(String a, String b, HashMap<String, ArrayList<String>> map2) {

		if (map.containsKey(a)) {
			ArrayList<String> list = map.get(a);
			list.add(b);
			map.put(a, list);

		}

		else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(b);
			map.put(a, list);

		}

	}

}
