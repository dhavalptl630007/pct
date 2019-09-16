package com.practice.test.pct;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

class TreeNode2 {
	int data;
	TreeNode2 left;
	TreeNode2 right;

	TreeNode2(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}

public class Lab11 {

	private static int root_level;
	private static LinkedHashMap<Integer, ArrayList<Integer>> map = new LinkedHashMap<Integer, ArrayList<Integer>>();
	private static boolean flag;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		String[] arr = sc.nextLine().split("\\s+");

		TreeNode2 root = new TreeNode2(Integer.parseInt(arr[0]));

		for (int i = 1; i < arr.length; i++) {
			createtree(root, Integer.parseInt(arr[i]));
		}

		int h = height(root);

		for (int i = 0; i <= h; i++) {
			root_level = i + 1;
			ArrayList<Integer> list = new ArrayList<Integer>();
			leveltraversal(root, i + 1, list);

		}
		
		System.out.println(map);
        checkforperfectBST();
        
        if (flag == true)
        {
        	System.out.println("YES");
        }
        else if (flag == false)
        {
        	System.out.println("NO");
        }
	}

	private static void checkforperfectBST() {
		
	 for (Entry<Integer,ArrayList<Integer>> entry : map.entrySet())	
	 {
		  int level = entry.getKey() -1;
		  ArrayList<Integer> nodes = entry.getValue();
		  
		  int leaves =  (int) Math.pow(2,level);
		  
		  if ( leaves == nodes.size())
		  {
			  flag = true;
		  }
		  else
		  {
			  flag = false;
		  }
	 	  
	 }
		
		
	}

	private static void leveltraversal(TreeNode2 root, int level, ArrayList<Integer> list) {

		if (root == null) {
			return;
		}

		if (level == 1) {
			if (map.containsKey(root_level)) {
				map.get(root_level).add(root.data);
			} else {
				list.add(root.data);
				map.put(root_level, list);
			}
		}
		
		else if (level > 1)
		{
			leveltraversal(root.left,level-1,list);
			leveltraversal(root.right,level-1,list);
		}

	}

	private static int height(TreeNode2 root) {

		if (root == null) {
			return -1;
		}

		return 1 + Math.max(height(root.left), height(root.right));
	}

	private static void createtree(TreeNode2 root, int data) {

		if (root == null) {
			return;
		}

		if (root.left == null && data < root.data) {
			root.left = new TreeNode2(data);

		} else if (root.right == null && data > root.data) {
			root.right = new TreeNode2(data);

		}

		if (data < root.data) {
			createtree(root.left, data);

		} else if (data > root.data) {
			createtree(root.right, data);

		}

	}

}
