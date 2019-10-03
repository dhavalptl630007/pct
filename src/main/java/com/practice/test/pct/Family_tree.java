package com.practice.test.pct;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

class TreeNode3 {
	String data;
	TreeNode3 left;
	TreeNode3 right;

	TreeNode3(String data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}

public class Family_tree {

	private static LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
	private static ArrayList<String> allnodes = new ArrayList<String>();
	private static ArrayList<String> resultset = new ArrayList<String>();
	
    private static boolean flag;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int rel = Integer.parseInt(sc.nextLine());

		String[] arr1 = sc.nextLine().split("\\s+");

		TreeNode3 root = new TreeNode3(arr1[0]);
		allnodes.add(arr1[0]);
		allnodes.add(arr1[1]);
		createmap(arr1[0], arr1[1]);
		
		//createtree(root, arr1[0], arr1[1]);

		for (int i = 1; i < rel; i++)

		{
			String[] arr = sc.nextLine().split("\\s+");
			createmap(arr[0], arr[1]);
			
		}

		createtree(root,map);
	//	System.out.println(map);
		
		
		int n = Integer.parseInt(sc.nextLine());
		
		for ( int i = 0; i <n; i++)
		{
			flag = false;
			String arr[] = sc.nextLine().split("\\s+");
			
			if (arr[1].equals( "child"))
			{
				flag = checkforchild(arr[0],arr[2]);
				if (flag == true)
				{
					resultset.add("T");
				}
				else
				{
					resultset.add("F");
				}
				//System.out.println(flag);
				
			}
			else if (arr[1].equals ("sibling"))
			{
				flag = checkforsibling(arr[0],arr[2]);
				//flag = checkforchild(arr[0],arr[2]);
				if (flag == true)
				{
					resultset.add("T");
				}
				else
				{
					resultset.add("F");
				}
				//System.out.println(flag);
				
			}
			else if (arr[1].equals ("ancestor"))
			{
				ArrayList<String> list = new ArrayList<String>();
				getancestor(root,arr[0],list);
				if (list.contains(arr[2]))
				{
					flag = true;
					
				}
				
				if (flag == true)
				{
					resultset.add("T");
				}
				else
				{
					resultset.add("F");
				}
				
			}
		
			else if (arr[1].equals ("descendant"))
			{
				ArrayList<String> list = new ArrayList<String>();
				getancestor(root,arr[2],list);
				if (list.contains(arr[0]))
				{
					flag = true;
					
				}
				
				if (flag == true)
				{
					resultset.add("T");
				}
				else
				{
					resultset.add("F");
				}
				
			}
		}
		
		for (int i = 0 ; i<resultset.size();i++)
		{
			if (i == resultset.size() -1 )
			{
			System.out.println(resultset.get(i));
			}
			else
			{
				System.out.print(resultset.get(i)+ " ");
			}
			
		}
		preorder(root);
		
		sc.close();

	}

	private static void getancestor(TreeNode3 root,String source, ArrayList<String> list) {
		
		if (root == null)
		{
			return;
		}
		
		if (root.data.equals(source))
		{
		
		ancestor(root,list);
		return;
		//ancestor(root.right,source,target,list);
		
		}
		
		 getancestor(root.left, source,list);
		 getancestor(root.right,source,list);
	}

	private static void ancestor(TreeNode3 root, ArrayList<String> list) {
		
		if (root == null)
		{
			return;
		}
		
		list.add(root.data);
		ancestor(root.left,list);
		ancestor(root.right,list);
		
	}

	private static boolean checkforsibling(String child1, String child2) {
		
		for (Entry<String,ArrayList<String>> entry : map.entrySet())
		{
			String pair = entry.getKey();
			
			ArrayList<String> list = entry.getValue();
			
			if (list.contains(child1) && list.contains(child2))
			{
				flag = true;
				return flag;
			}
					
			
		}
		
		return false;
	}

	private static boolean checkforchild(String child, String parent) {
		
		if (map.containsKey(parent))
		{
			ArrayList<String> list = map.get(parent);
			
			if (list.contains(child))
			{
				flag = true;
				return flag;
			}
			
		}
		
		return false;
	}

	private static void preorder(TreeNode3 root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.data +" ");
		
		preorder(root.left);
		preorder(root.right);
	}

	private static void createtree(TreeNode3 root, LinkedHashMap<String,ArrayList<String>>map) {

		if (root == null) {
			return;
		}
		
		if (map.containsKey(root.data))
		{
		   ArrayList<String> child = map.get(root.data);
			
		   if (child.size() == 1)
		   {
			   TreeNode3 leftnode = new TreeNode3(child.get(0));
			   root.left = leftnode;
		   }
			  
		   else if (child.size() == 2)
		   {
			   TreeNode3 leftnode = new TreeNode3(child.get(0));
			   TreeNode3 rightnode = new TreeNode3(child.get(1));
			   root.left = leftnode;
			   root.right = rightnode;
		   }
		   
		}
		
		
		createtree(root.left,map);
		createtree(root.right,map);
		
		
	}

	private static void createmap(String parent, String child) {

		if (allnodes.contains(parent)) {

			if (map.containsKey(parent)) {
				map.get(parent).add(child);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(child);
				map.put(parent, list);

			}

			allnodes.add(parent);
			allnodes.add(child);
		} else {
			return;
		}

	}

}
