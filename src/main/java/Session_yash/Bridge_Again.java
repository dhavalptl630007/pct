package Session_yash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

public class Bridge_Again {

	private static HashMap<String, ArrayList<String>> graphmap = new HashMap<String, ArrayList<String>>();
//	private static HashMap<String, Integer> distmap = new HashMap<String, Integer>();
	private static ArrayList<String> visited = new ArrayList<String>();
	private static Stack<String> st = new Stack<String>();
	private static HashMap<String, Integer> time = new HashMap<String, Integer>();
	private static int disc = 0;
	private static int bridge =0;
	private static int maxbridge =0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int v = Integer.parseInt(sc.nextLine());
		int n_edge = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n_edge; i++) {
			String[] arr = sc.nextLine().split("\\s+");

			creategraph(arr[0], arr[1]);
		}

		findbridges();

		System.out.print(bridge + " "+maxbridge);
	}

	private static void findbridges() {

		for (Entry<String, ArrayList<String>> entry : graphmap.entrySet()) {
			String rootnode = entry.getKey();

			if (!visited.contains(rootnode)) {
				DFS(rootnode);
			}

		}

	}

	private static void DFS(String rootnode) {
		visited.add(rootnode);
		st.push(rootnode);
		disc++;
		time.put(rootnode, disc);

		ArrayList<String> adjacentNodes = graphmap.get(rootnode);

		if (adjacentNodes != null) {
			for (String node : adjacentNodes) {
				if (!visited.contains(node)) {
					DFS(node);
				}
			}

		}
		

    String parent = st.pop();
    if (st.isEmpty())
    {
    	st.push(parent);
    }
    if (parent.equals(rootnode))
    {
    	parent = st.lastElement();
    }

   
    
		
 int smallesttime = gettime(parent,rootnode);	

  if (time.get(parent) < smallesttime)
  {
	  bridge++;
	  maxbridge = Math.max(maxbridge,Math.max(Integer.parseInt(parent),Integer.parseInt(rootnode)));
  }
	
		

	}

	private static int gettime(String parent, String node) {
		
		ArrayList<String> adjacentNodes = graphmap.get(node);
        int min = time.get(node);
		if (adjacentNodes != null) {
			for (String node1 : adjacentNodes) {
			
			      if (!node1.equals(parent))	
			      {
			    	  if (min > time.get(node1))
			    	  {
			    		  min = time.get(node1);
			    	  }
			    	  
			      }
				
			}
			
		 time.put(node,min);

		}
		return min;
	}

	private static void creategraph(String a, String b) {

		if (graphmap.containsKey(a)) {
			graphmap.get(a).add(b);
		}

		else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(b);
			graphmap.put(a, list);
		}

		if (graphmap.containsKey(b)) {
			graphmap.get(b).add(a);
		}

		else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(a);
			graphmap.put(b, list);
		}
	}

}
