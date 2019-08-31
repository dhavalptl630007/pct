package com.practice.test.pct;

import java.util.Scanner;

public class pct_practice_1_dhaval {

	public static void main (String [] args)
	{
		
	  Scanner sc = new Scanner (System.in);
	  
	  
	  int numberofplayers = Integer.parseInt(sc.nextLine());
	  
	  String name;
	  int onepoint;
	  int twopoint;
	  int threepoint;
	  int numofminutes;
	  int ppm;
	  int maxppm = 0;
	  String maxname = null;
	 
	  
	  for ( int i = 0; i < numberofplayers; i++  )
	  {
	   name = sc.nextLine();
	   onepoint = Integer.parseInt(sc.nextLine());
	   twopoint = Integer.parseInt(sc.nextLine());
	   threepoint = Integer.parseInt(sc.nextLine());
	   numofminutes = Integer.parseInt(sc.nextLine());
	     
	      ppm = getppm(onepoint,twopoint,threepoint,numofminutes);
	      
	      if (ppm > maxppm)
	      {
	    	  maxppm = ppm;
	    	  maxname = name;
	    	  
	      }
	      
	   
	  }
	  
	  
	 System.out.println(maxname+" "+maxppm);
	 sc.close(); 
	 
		
	}

	private static int getppm(int onepoint, int twopoint, int threepoint, int numofminutes) {
		
		int sum = onepoint + twopoint*2 + threepoint*3;
	    float  ppm = ((float)sum / numofminutes) * 1000;
	    
	    return Math.round(ppm);
			
	}
	
	
	
	
}
