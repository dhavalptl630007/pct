package Session_yash;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Longest_SubString {

	private static LinkedHashSet<String> set = new LinkedHashSet<String>();
	private static int maxlength;
	public static void main(String[] args) {

	 Scanner sc = new Scanner(System.in);
	 String str = sc.nextLine();
	
	 String f_string = null;
	 	 

	for (int i = 0 ; i <str.length(); i++)  
	{
	   for (int j = i+1 ; j<str.length();j++)
	   {
		  
		 set.add(str.substring(i, j));
	        
		
	   }
	}
	 
	System.out.println(set);
	
	for (String s : set)
	{
	  
	   int  flag = checkforunique(s); 	
	   
	   if (flag == 1)
	   {
	     int len = s.length();
		  
	      if (len> maxlength)
	      {
	        maxlength = len;
	      
	          f_string = s;     
	      }
	   }
	}
	
	 System.out.println(f_string);
	
	}
	private static int checkforunique(String s) {
		
		
		 for (int i = 0; i<s.length(); i++)
		 {
			for (int j = i+1; j<s.length(); j++) 
			{
			 if (s.charAt(i)==s.charAt(j)) 
			 {
		       return 0;
		       
			 }
	
			}
		 }
		
		return 1;
	}

}
