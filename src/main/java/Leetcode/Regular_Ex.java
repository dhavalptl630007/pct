package Leetcode;
// refere below video
//https://youtu.be/bSdw9rJYf-I
/*

aa
a
false

aa
a*
true

ab
.*
true

aab
c*a*b*
true

mississippi
mis*is*p*.
false


*/
import java.util.Scanner;

public class Regular_Ex {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		String p = sc.nextLine();
		
		boolean b = isMatch(s,p);
		System.out.println(b);
		

	}

	private static boolean isMatch(String s, String p) {
	
		 if (p.length()==0) return s.length() == 0;
		 
		 boolean firstmatch = (s.length() >0 && (s.charAt(0) == p.charAt(0) ) || p.charAt(0) == '.'); //first case
		 
		 if (p.length() >= 2 && p.charAt(1) == '*')
		 {
		 return (isMatch(s,p.substring(2))) || (firstmatch && isMatch(s.substring(1),p)); // (use do not use wildcard or  use wild card)
		 }
		 else // general case
		 {
			return firstmatch && isMatch(s.substring(1),p.substring(1));	 
		 	 
		 }
	
	}

}
