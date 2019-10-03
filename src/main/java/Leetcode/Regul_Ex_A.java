package Leetcode;

import java.util.Scanner;

public class Regul_Ex_A {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		String p = sc.nextLine();
		
		boolean flag = isMatch(s,p);
		System.out.println(flag);
		

	}

	private static boolean isMatch(String s, String p) {
		
		if (p.length() == 0 ) return (s.length()== 0);
	  	
		boolean firstmatch = ( s.length() > 0 && ( p.charAt(0) == s.charAt(0) ||p.charAt(0) =='.' ));
				
		if (p.length()>=2 && p.charAt(1)== '*')
		{
			return isMatch(s,p.substring(2)) ||firstmatch && isMatch(s.substring(1),p) ;
			
		}
		else
		{
			return firstmatch && isMatch(s.substring(1),p.substring(1));
		}
		
	
	}

}
