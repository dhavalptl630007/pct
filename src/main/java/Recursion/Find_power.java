package Recursion;

public class Find_power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	 int p = findpower(2,5)	;
	 System.out.println(p);
	}

	private static int findpower(int i, int j) {
		
	 if (  j == 0)
	 {
		 return 1;
	 }
		
		return  i * findpower(i,j-1);
	}

}
