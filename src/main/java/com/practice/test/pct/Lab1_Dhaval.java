package com.practice.test.pct;

import java.util.ArrayList;
import java.util.Scanner;


public class Lab1_Dhaval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	  int sum = 0;	
      Scanner sc = new Scanner(System.in);
      String line = sc.nextLine();
      ArrayList<Integer> list = new ArrayList<Integer>();
      
      for (int i = line.length() - 1; i>=0; i--)
      {
    	  
    	 list.add(Integer.parseInt(Character.toString(line.charAt(i))));
    	  
      }
      
      if (list.size() <20)
      {
    	 for ( int i = 0 ; i <= list.size() -1 ; i++) 
    	 {
    		 if (i % 2 != 0)
    		 {
    		    int temp = list.get(i) * 2;
    		    
    		    int temp2 = findsum(temp);
    		    
    		    sum = sum + temp2;
    			 
    		 }
    		 
    		 else
    		 {
    			sum = sum + list.get(i);
    			  			 
    		 }
    		 
    	 }
    	 
    	 
    		 if ( sum % 10 == 0)
    		 {
    			 System.out.println("VALID");
    			 
    			 
    		 }
    		 
    		 else 
    		 {
    			 System.out.println("INVALID"); 
    			 
    		 }
    		 
    		 
    		 
    	 
    		 
    	  
      }
      
      
      sc.close();
	}
	
	
	  public static int findsum(int sum)
	  {
		  
		int rem = sum % 10;
		int a = (sum - rem)/ 10;
		int ans = a + rem;
		return ans;
		    
	  }

}
