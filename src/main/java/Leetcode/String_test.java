package Leetcode;

import java.util.Scanner;

public class String_test {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	String strs[] = sc.nextLine().split("\\s+");
		
		  if (strs.length == 0)
		  {
			  
		  }
		    String prefix = strs[0];
		    for (int i = 1; i < strs.length; i++)
		        while (strs[i].indexOf(prefix) != 0) {
		            prefix = prefix.substring(0, prefix.length() - 1);
		            if (prefix.isEmpty())
		            {
		            	System.out.println("");
		            }
		        } 
		    
             System.out.println(prefix);
	}

}
