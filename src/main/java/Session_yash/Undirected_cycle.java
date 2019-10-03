package Session_yash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

public class Undirected_cycle {

	private static HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
	private static ArrayList<String> visited = new ArrayList<String> ();
	private static Stack<String> st = new Stack<String>();
	private static int cycle = 0;
	
	public static void main(String[] args) {
	
	 Scanner sc = new Scanner (System.in);
	 int v = Integer.parseInt(sc.nextLine());
	 int e = Integer.parseInt(sc.nextLine());
	 
	 for ( int i = 0; i<e ; i ++)
	 {
		 String [] arr = sc.nextLine().split("\\s+");
		 creategraph(arr[0],arr[1]);
		 
	 }
	 
	
	  for (Entry<String,ArrayList<String>> entry : map.entrySet())
	  {
		  String rootnode = entry.getKey();
		  if (!visited.contains(rootnode))
		  {
		     DFS(rootnode,rootnode);
		  }
	  }
	 
	  if (cycle >0)
	  {
		  System.out.println("YES");
	  }
	  else
	  {
		  System.out.println("NO"); 
	  }
    
	}

	private static void DFS(String node, String rootnode) {
	 visited.add(node);	
	 st.push(node);
		
	  ArrayList<String> adjacentNodes = map.get(node);
	  
	  if (adjacentNodes != null)
	  {
		  
		 for (String adjacentNode : adjacentNodes) 
		 {
			 if (!visited.contains(adjacentNode))
			 {
				 
				 DFS(adjacentNode,rootnode);
			 }
			 
		 }
		  
		 for (String adjacentNode : adjacentNodes) 
		 {

			 if (visited.contains(adjacentNode) &&  !adjacentNode.equals(getParent(node)))
			 {
				 
				 cycle++;
			 }
			 
		 }
	   
		 
		 
		  
		  
	  }
	 
	 String lastElement = st.pop();
		
		if(lastElement.equals(rootnode)) {
			st.push(rootnode);
		}
		
	}

	private static String getParent(String node) {
	
		Stack<String> tempstack = (Stack<String>) st.clone();
		
		String parent = tempstack.pop();
	    if (tempstack.isEmpty())
	    {
	    	tempstack.push(parent);
	    }
		
	    if (parent.equals(node))
	    {
	    	parent = tempstack.lastElement();
	    }
		
		return parent;
		
		
		
	}

	private static void creategraph(String a, String b) {
		
		if (map.containsKey(a))
		{
			map.get(a).add(b);
		}
		
		else
		{
			
		 ArrayList<String>	list = new ArrayList<String>();
		 map.put(a,list);				
		}
		
		if (map.containsKey(b))
		{
			map.get(b).add(a);
		}
		
		else
		{
			
		 ArrayList<String>	list = new ArrayList<String>();
		 map.put(b,list);				
		}
	}

}
