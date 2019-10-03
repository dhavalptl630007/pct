package Session_yash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.Map.Entry;

public class D_Cycle_A {

	private static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	private static ArrayList<String> visited = new ArrayList<String>();
	
	private static Stack<String> st = new Stack<String>();
	private static HashMap<String, String> nodeFlag = new HashMap<String, String>();
	private static int cycle = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int v = Integer.parseInt(sc.nextLine());
		int e = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < e; i++) {
			String[] arr = sc.nextLine().split("\\s+");
			creategraph(arr[0], arr[1]);

		}

		InitializeFlag();

		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {

			String rootnode = entry.getKey();

			if (!visited.contains(rootnode)) {
				DFS(rootnode, rootnode);

			}

		}
		System.out.println("cycleCount -- "+map);
		//System.out.println("numberOfVertices -- "+numberOfVertices);
		System.out.println("cycleCount -- "+cycle);
		//System.out.println("cycleDetected -- "+isCycleDetected);
		
		sc.close();

	}

	private static void InitializeFlag() {

		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
			String key = entry.getKey();

			nodeFlag.put(key, "-1");

			ArrayList<String> adjacentNodes = entry.getValue();

			for (String adjacentNode : adjacentNodes) {
				nodeFlag.put(adjacentNode, "-1");
			}

		}

	}

	private static void DFS(String node, String rootnode) {

		visited.add(node);
		nodeFlag.put(node, "0");
		st.push(node);
		

		ArrayList<String> adjacentNodes = map.get(node);

		if (adjacentNodes != null) {
			for (String adjacentNode : adjacentNodes) {

				if (!visited.contains(adjacentNode)) {
					DFS(adjacentNode, rootnode);

				}

			}
		}

		
		if (adjacentNodes != null) {
			for (String adjacentNode : adjacentNodes) {

				if (nodeFlag.get(adjacentNode).equals("0")) {
					
					cycle++;
					print(node,adjacentNode);

				}

			}
		}

		
		String element = st.pop();

		if (element.equals(rootnode)) {
			st.push(rootnode);
		}
		nodeFlag.put(node, "1");

	}

	private static void print(String node, String adjacentNode) {
		
		Stack<String> tempstack = (Stack<String>) st.clone();
		ArrayList<String> cyclechecked = new ArrayList<String>();
		
		 while(!adjacentNode.equals( tempstack.lastElement()))
		 {
			 String temp = tempstack.pop();
			 
			 cyclechecked.add(temp);
			 
			 
		 }
		 cyclechecked.add(adjacentNode);
		 Collections.reverse(cyclechecked);
		 System.out.println(cyclechecked);
		
		
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

//		if (map.containsKey(b)) {
//			map.get(b).add(a);
//		}
//
//		else {
//
//			ArrayList<String> list = new ArrayList<String>();
//			map.put(b, list);
//		}
	}

}
