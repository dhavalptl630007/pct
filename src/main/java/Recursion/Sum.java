package Recursion;

public class Sum {

	public static void main(String[] args) {
	
	int a[]	= { 10,20,30,40,50};
	
	int sum = getsum(a,a.length-1);
	System.out.println(sum);
	

	}

	private static int getsum(int[] a,int len) {
		
	 if (len<0)
	 {
		 return 0;
	 }
		
	 return a[len]+ getsum(a,len-1);
		
	}

}
