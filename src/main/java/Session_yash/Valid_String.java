package Session_yash;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Valid_String {

	
	private static HashMap<Character,Character> map = new HashMap<Character,Character>();
	
	public static void main(String[] args) {
	
	 Scanner sc = new Scanner (System.in);	

	 String s = sc.nextLine();
	 
	 String n = null;
	 
      
	 map.put(')','(');
	 map.put('}','{');
	 map.put(']','[');
	 
	 for (int i = 0; i<s.length();i++)
	 {
		 if ( ( s.charAt(i) == ')' ) || ( s.charAt(i) == '(' )|| ( s.charAt(i) == '{' ) || ( s.charAt(i) == '}' ) || 
			 ( s.charAt(i) == '[' ) || ( s.charAt(i) == ']' )){
			 
			 n = n+s.charAt(i);  	 
		 }
		 
	 }
	 
	System.out.println( check(n.substring(4)));
	 
	}

	private static boolean check(String s) {
		
		Stack<Character> st = new Stack<Character>();
		char topelement;
		
	    for (int i = 0; i<s.length();i++)
	    {
	    	char c = s.charAt(i);
	    	// If the current character is a closing bracket.
	    	
	    	 if (map.containsKey(c))
	    	 {
	    		
	    		 
	    		 if (st.empty())
	    		 {
	    			 topelement = '#';
	    		 }
	    		 
	    		 else
	    		 { 
	    			 topelement = st.pop();
	    			 
	    			// If the mapping for this bracket doesn't match the stack's top element, return false.
	    			 if (topelement != map.get(c))
	    			 {
	    				 return false;
	    			 }
	    			 
	    		 }
	    		 
	    		 
	    	 }
	    	 
	    	 else
	    	 {
	    		st.push(c) ;
	    		 
	    	 }
		
	    }
	    
	      return st.isEmpty();
	    
		
	}

}
