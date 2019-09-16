package Session_yash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

public class Deadlock {

	private static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	private static HashMap<String, ArrayList<String>> DFSAll = new HashMap<String, ArrayList<String>>();
	private static ArrayList<String> visited = new ArrayList<String>();
	private static ArrayList<String> Allvisited = new ArrayList<String>();
	private static HashSet<ArrayList<String>> cycle = new HashSet<ArrayList<String>>();
	//private static int cycle = 0;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int ver = Integer.parseInt(sc.nextLine());
		int edg = Integer.parseInt(sc.nextLine());
        
		for (int i = 0; i < edg; i++) {
			String[] arr = sc.nextLine().split("\\s+");

			creategraph(arr[0], arr[1], map);

		}

		Iterator itr = map.entrySet().iterator();

		while (itr.hasNext()) {
         Map.Entry pair = (Map.Entry)itr.next();
         
         String key = (String) pair.getKey();
          Allvisited.add(key);
           if (!visited.contains(key)) 
           {
        	  // System.out.print(key+"  ");
        	    DFS(key);
        	   
           }
         
         
         ArrayList<String> temp = new ArrayList<String>(Allvisited);
         DFSAll.put(key,temp); 
         Allvisited.clear();  
         visited.clear();
		}
		
	System.out.println(DFSAll);
	findputcycle();
	
	
	
	
	System.out.println(cycle);
	
	}

	private static void findputcycle() {
		
	 Iterator itr = DFSAll.entrySet().iterator();
	 
	 while(itr.hasNext())
	 {
		 Map.Entry pair = (Map.Entry) itr.next();
		 
		 List<String> list = (List<String>) pair.getValue();
		
		 //Map.Entry pair = (Map.Entry) itr.next().next();
		 
		 if (pair.getKey().equals(list.get(0)))
	 	 {
		
			  if (list.get(0).equals(list.get(list.size()-1)))
			  {
				  
				Collections.sort(list);
				 
				  
				  
			  }
			 
			 
	 	 }
	 }
	 
		
	}

	private static void DFS(String key) {
	  visited.add(key);
	  // explore neigbor 
	
	   ArrayList<String> list= map.get(key);
	  
	   if (list !=null)
	   {
	   Iterator<String> itr = list.listIterator();
            	
	    while (itr.hasNext())
	    {
	       String str = itr.next();
	       Allvisited.add(str);
	        if (!visited.contains(str)) 
	        {
	        	 // System.out.print(str+"  ");
	        	  DFS(str);
	        }
	    }
	   
	   }
	}

	private static void creategraph(String a, String b, HashMap<String, ArrayList<String>> map) {

		if (map.containsKey(a)) {
			map.get(a).add(b);
		} else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(b);
			map.put(a, list);
		}
		
//		if (map.containsKey(b)) {
//			map.get(b).add(a);
//		} else {
//			ArrayList<String> list = new ArrayList<String>();
//			list.add(a);
//			map.put(b, list);
//		}
	}

}
