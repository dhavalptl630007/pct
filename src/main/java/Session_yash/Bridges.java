package Session_yash;

/// check the algorithm at below link:

//https://youtu.be/AK7BuT5MgU0

// stack was used to keep track of parent and child, during backtracking
// first node will give the child, so 2nd last node will give you the parent

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

/*
input
5
5
1 2
2 3
2 4
3 4
4 5
map
{1=[2], 2=[1, 3, 4], 3=[2, 4], 4=[2, 3, 5], 5=[4]}
output
2 5
input
9
11
1 2
2 3
3 4
2 4
1 3
2 8
5 7
6 7
5 6
0 7
0 8
map
{0=[7, 8], 1=[2, 3], 2=[1, 3, 4, 8], 3=[2, 4, 1], 4=[3, 2], 5=[7, 6], 6=[7, 5], 7=[5, 6, 0], 8=[2, 0]}
output
3 8
 */

public class Bridges {

	private static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	private static ArrayList<String> visited = new ArrayList<String>();
	private static Stack<String> s = new Stack<String>();
	private static int time = 0;
	private static HashMap<String, Integer> disctime = new HashMap<String, Integer>();
	//private static String parent;
	private static int bridge = 0;
	private static int maxBridge = 0;
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int v = Integer.parseInt(sc.nextLine());
		int e = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < e; i++) {
			String[] arr = sc.nextLine().split("\\s+");
			creategraph(arr[0], arr[1]);

		}

		findbridges();
		
		System.out.print(bridge + " "+ maxBridge);

	}

	private static void findbridges() {

		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
			String rootnode = entry.getKey();

			if (!visited.contains(rootnode)) {
				DFS(rootnode);

			}
		}
	}

	private static void DFS(String rootnode) {

		visited.add(rootnode);
		s.push(rootnode);
		time++;
		disctime.put(rootnode, time);
       // parent = rootnode;
		ArrayList<String> adjacentnodes = map.get(rootnode);

		if (adjacentnodes != null) {
			for (String node : adjacentnodes) {
				if (!visited.contains(node)) {
					DFS(node);
				}
			}
		}
		
		
	  String parent = s.pop();
	   if (s.empty())
	   {
		 s.push(parent);
        }
      if (parent.equals(rootnode)) 
	  {
		  parent = s.pop();
	  }
	  
      if (s.empty())
	   {
		 s.push(parent);
       }	
	      /// find the smallest time from the adjacent vertices except the parent
	  int smallesttime = getsmallesttime(parent,rootnode);
       
	  // can find the bridge if new disctime is greater than the parent
	  
	  if (disctime.get(parent)< smallesttime)
	  {
		  bridge++;
		  int max =  Math.max(Integer.parseInt(parent),Integer.parseInt(rootnode));
		  maxBridge = Math.max(max,maxBridge);
		  
	  }
	  
      
	}

	private static int getsmallesttime(String parent, String node) {
		
		ArrayList<String> adjacentnodes = map.get(node);
         int mintime = disctime.get(node); /// time of particular node
		if (adjacentnodes != null) {
			for (String tempnode : adjacentnodes) {
				if (!tempnode.equals(parent) ) { // borrow minimum disc time from adjacent node except the parent
				     
				    int time = disctime.get(tempnode); 	
					
				    mintime = Math.min(time, mintime);
				     
				     
				}
			}
			
				
		}
		
		disctime.put(node,mintime); // update the new disc time	
		
		return mintime;
	}

	private static void creategraph(String a, String b) {

		if (map.containsKey(a)) {
			map.get(a).add(b);

		}

		else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(b);
			map.put(a, list);
		}

		if (map.containsKey(b)) {
			map.get(b).add(a);

		}

		else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(a);
			map.put(b, list);
		}

	}

}
