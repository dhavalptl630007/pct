package com.practice.test.pct;

public class Possible_St {

	public static void main(String[] args) {
	
	String st = "aaaaaa";
	int count = 0;
	
	//for ( int i = 0; i <st.length(); i++)
//	{
		for (int j  = 0 ; j <= st.length()-2; j++ )
		{
			String s = Character.toString(st.charAt(j)) + Character.toString(st.charAt(j+1));
		System.out.println(s);
		count++;
			
		}
//	}
	
	
 System.out.println(count);
	
			
		

	}

}
