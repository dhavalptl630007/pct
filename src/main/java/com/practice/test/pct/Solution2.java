package com.practice.test.pct;

// nice problem level traversal using linkedlist. using iteration.

// Store address in list
// left view and rightview
// store the tree in map , level by level
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.DelayQueue;
import java.io.*;
import java.lang.Math;

class Node11 {
    Node11 left;
    Node11 right;
    int data;
    
    Node11(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution2 {

	/* 
    
    class Node11 
    	int data;
    	Node11 left;
    	Node11 right;
	*/
	
	private static LinkedList<Node11> q = new LinkedList<Node11>();
	//private static Node11 cur = null;
	
	private static HashMap<Integer, ArrayList<Integer>> map = new  HashMap<Integer, ArrayList<Integer>>();
	private static int root_level;
	public static void levelOrderrec(Node11 root) {
		
	 int h = height(root);	
	 System.out.println(h);
	 	
	 for (int i = 0; i <=h ; i++)
	 {
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 root_level = i+1;
		 Printlevel(root, i+1, list);
		 System.out.println();
		 
		 
	 }
	
//	 System.out.println();
	}
	
	private static void Printlevel(Node11 root, int level, ArrayList<Integer> list ) {
		
		
		
		if (root == null)
		{
			return;
		}
		
		if (level == 1)
		{
		 	System.out.print(root.data+" ");
		    if (map.containsKey(root_level))
		    {
		    map.get(root_level).add(root.data);
		 	
		    }
		    else
		    {
		     list.add(root.data); 	
		    map.put(root_level,list);
		    }
		}
		
	   else if (level > 1)	
    	{
		   Printlevel(root.left, level-1,list);
		   Printlevel(root.right, level-1,list);   
		
	     }
	
	}

	private static int height(Node11 root) {
		 if (root == null)
		 {
		return -1;
		 }
		 
		 return Math.max(height(root.left),height(root.right)) + 1; 
		 
	}

	public static void levelOrder(Node11 root) {
       
	  q.add(root);	 
       
	  while(!q.isEmpty()) 
	  {
		  
		 root = q.poll();
		
		 
	  System.out.print(root.data + " ");      
     
       if(root.left != null)
       {
    	 q.add(root.left);
    	   
       }

       if(root.right != null)
       {
    	   
    	   q.add(root.right);
       }
       
	  }
    }

	public static Node11 insert(Node11 root, int data) {
        if(root == null) {
            return new Node11(data);
        } else {
            Node11 cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node11 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
        levelOrderrec(root);
        System.out.println("Leftview");
        getleftview(root);
        System.out.println("rightview");
        getrightview(root);
    }

	private static void getrightview(Node11 root) {
		
		Iterator itr = map.entrySet().iterator();
		 int i = 1;
		 while(itr.hasNext()) {
			 
		  Map.Entry pair = (Entry) itr.next(); 
		  
		  ArrayList<Integer> list = map.get(i);
		  if(list.size()>=1)
		  {
	      System.out.println(list.get(list.size()-1));
		  }
	      i++;	 
		 }
		
	}

	private static void getleftview(Node11 root) {
		
	 Iterator itr = map.entrySet().iterator();
	 int i = 1;
	 while(itr.hasNext()) {
		 
	  Map.Entry pair = (Entry) itr.next(); 
	  
	  ArrayList<Integer> list = map.get(i);
      System.out.println(list.get(0));
      i++;	 
	 }
		
		
	}	
}
