package Recursion;

public class Palimdrome {

	private static boolean flag;

	public static void main (String[] args)
	{
		
		String s = "aaaab";
		
		
		 check(s,0);
		 System.out.println(flag);
		
		
	}

	private static void check(String s, int i) {
		
		//return false;
		int len = s.length()/ 2 ;
		if (i == ((s.length()/ 2) ))
		{
			return ;
		}
		
		check(s, i+1);
		if (s.charAt(i) != s.charAt(s.length()-1-i))
		{
			flag = false;
		}
		else
		{
			flag = true;
			
		}
		
	 
	}
	
}
