package Session_yash;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Palimdrome_sub {
	private static LinkedHashSet<String> set = new LinkedHashSet<String>();
	private static int maxlength;
	public static void main(String[] args) {

	 Scanner sc = new Scanner(System.in);
	 String sb = sc.nextLine();
	 StringBuffer str= new StringBuffer(sb);
	
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
	    
	   StringBuffer sb1 = new StringBuffer(s);	
	   int  flag = checkforpalim(sb1,s); 	
	   
	   if (flag == 1)
	   {
	     int len = s.length();
		  
	      if (len> maxlength)
	      {
	        maxlength = len;
	      
	          f_string = s.toString();     
	      }
	   }
	}
	
	 System.out.println(f_string);
	
	}
	private static int checkforpalim(StringBuffer sb, String s) {
		
		StringBuffer rev = sb.reverse();
		
		if (s.equals(rev.toString()))
		{
		
		return 1;
		}
	
		return 0;
	}


}


