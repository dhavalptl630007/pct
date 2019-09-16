package Session_yash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

// check for below link for algorith:

//https://youtu.be/AK7BuT5MgU0

/*
5
6
a b
a c
b c
b d
d e
e b
 */



public class D_Cycle {

	 private static HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
	 private static LinkedHashMap<String,String> childParent = new LinkedHashMap<String,String>();
	 private static HashMap<String,String> nodeflag = new HashMap<String,String> ();
	 private static Stack<String> stack = new Stack<String>();
	 private static ArrayList<String> visited = new ArrayList<String>();
	 private static boolean isCycledetected = true;
	 private static int cycle =0;
	 
	public static void main(String[] args) {
	
	 Scanner sc = new Scanner(System.in);
	 int v = Integer.parseInt(sc.nextLine());
	 int e = Integer.parseInt(sc.nextLine());
	 
	  for (int i = 0; i< e; i++)
	  {
		String[] arr = sc.nextLine().split("\\s+");
		creategraph (arr[0],arr[1]); 
		 
	  }
	 
		Initializeflag();
	  
		 for (Entry<String,ArrayList<String>> entry : map.entrySet())
		  {
			   String rootnode = entry.getKey();
			   
			   if (!visited.contains(rootnode))
			   {
				   DFS(rootnode,rootnode); // to keep track of the root, pass node and it's root
			   }
			    
			  
		  }
		
		
		
		

	}


	private static void DFS(String node, String rootnode) {
		
	 visited.add(node);
	 stack.push(node);
	 nodeflag.put(node,"0");
	
	 String parent = getParent(node);
	 
	 childParent.put(node, parent.equals(node)? rootnode : parent);
	 
	 
	  ArrayList<String> adjacentnodes = map.get(node);
	  
	  if (adjacentnodes !=null)
	  {
	  for(String adjacentnode : adjacentnodes )
	  {
		  if (!visited.contains(adjacentnode))
		  {
			  DFS(adjacentnode, rootnode);
		  }
	  }
		
	  for(String adjacentnode : adjacentnodes )
	  {
		   if (nodeflag.get(adjacentnode).equals("0")) 
		   {
			   isCycledetected = true;
			   printcycle(node,adjacentnode);
		   }
		  
	  }
		
	  }
	  
	  
	  String lastelement = (String) stack.pop();
	  if (lastelement.equals(rootnode))
	  {
	    stack.push(rootnode);
	  }
	  nodeflag.put(node,"1");	  
	}

	private static String getParent(String node) {
		
	  Stack<String> tempstack = (Stack<String>) stack.clone();
	  
	  String parent = tempstack.pop();
	  
	  if (tempstack.empty())
	  {
		  tempstack.push(parent);
	  }
		  
	  
	  
	   if (parent.equals(node))
	   {
	       parent = tempstack.pop();
		
	   }
	   
		return parent;
	}


	private static void printcycle(String node, String adjacentnode) {
		
		System.out.print("Cycle   " + adjacentnode);
		
		while(true)
		{
			
			System.out.print("--->"+node);	
			
			String parent = childParent.get(node);
		    
			if (parent.equals(adjacentnode))
			{
				break;
			}
			
			node = parent;
		}
		
		
	}


	private static void Initializeflag() {
		
	  for (Entry<String,ArrayList<String>> entry : map.entrySet())
	  {
		   nodeflag.put(entry.getKey(), "-1");
		   
		    for (String node : entry.getValue())
		    {
		    	
		    	nodeflag.put(node, "-1");
		    }
		  
	  }
		
		
	}


	private static void creategraph(String a, String b) {
		
		if (map.containsKey(a))
		{
			map.get(a).add(b);
			
		}
		
		else
		{
			ArrayList<String> list = new ArrayList<String>();
			list.add(b);
			map.put(a,list);
		}
	}

}
