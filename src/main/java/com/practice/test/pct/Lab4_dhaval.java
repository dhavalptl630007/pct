package com.practice.test.pct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	int data;
	Node left, right;

	Node(int element) {
		data = element;
		left = null;
		right = null;

	}

	public Node() {
		// TODO Auto-generated constructor stub
	}
}

public class Lab4_dhaval {

	private static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String arr[] = str.split("\\s+");

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			list.add(Integer.parseInt(arr[i]));

		}

		Node tree = new Node(list.get(0));
        Node root = new Node();
        root = tree;
		for (int j = 1; j < list.size(); j++) {

			createtree(root, list.get(j));

		}
        
		root = tree;
		checkheight(root);

		if (flag == true) {
			root = tree;
			preordertravse(root);

		}
		
		else if (flag == false) {
			System.out.println("NOT");

		}
		
		sc.close();
	}

	private static void preordertravse(Node root) {

		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");

		preordertravse(root.left);
		preordertravse(root.right);

		
		
	}

	private static void checkheight(Node root) {

		if (root == null) {
			return;
		}
		
		int leftheight = checkleftheight(root);
		int rightheight = checkrightheight(root);

		if (leftheight - rightheight == 0 || leftheight - rightheight == 1 || leftheight - rightheight == -1) {
			flag = true;

		}

		else {
			flag = false;
			return;

		}

		checkheight(root.left);
		checkheight(root.right);

	}

	private static int checkrightheight(Node root) {
		int rightheight = 1;
		if (root == null) {
			return 0;
		}
		rightheight += checkrightheight(root.right);

		return rightheight;

	}

	private static int checkleftheight(Node root) {

		int leftheight = 1;
		if (root == null) {
			return 0;
		}
		leftheight += checkleftheight(root.left);

		return leftheight;

	}

	private static void createtree(Node root, int element) {

		Node newnode = new Node(element);

		if (root.left == null && element < root.data) {

			root.left = newnode;

		} else if (root.right == null && element > root.data) {
			root.right = newnode;

		}

		if (element < root.data) {
			createtree(root.left, element);

		} else if (element > root.data) {
			createtree(root.right, element);

		}

	}

}
