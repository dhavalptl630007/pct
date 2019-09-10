package com.practice.test.pct;

import java.util.*;
import java.io.*;


class Node10 {
    Node10 left;
    Node10 right;
    int data;
    
    Node10(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/*
    class Node10 
    	int data;
    	Node10 left;
    	Node10 right;
	*/

    static int height = 0;
	public static int height(Node10 root) {
      
     
      if (root==null)
      {
         return 0;

      }      
      
       if (root.left !=null || root.right !=null)
       {
      height =  findmax(leftheight(root.left),righttheight(root.right)); 
       }

      return height;
    }

    public static int leftheight(Node10 root) {

      if(root == null)
      {
          return 0;
      }
   
     
     height = 1 + findmax(leftheight(root.left),righttheight(root.right));
     return height;

    }
    
     public static int righttheight(Node10 root) {

      if(root == null)
      {
          return 0;
      }
     
     height = 1+ findmax(leftheight(root.left), righttheight(root.right));
     return height;

    }

    
   public static int findmax(int a, int b) {

      if(a>=b)
      {
          return a;
      }
      else
      {
          return b;
      }
    }




	public static Node10 insert(Node10 root, int data) {
        if(root == null) {
            return new Node10(data);
        } else {
            Node10 cur;
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
        Node10 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}
