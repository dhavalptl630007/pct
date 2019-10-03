package Leetcode;

public class Robot_Again {

	public static void main(String[] args) {
		
	 int [][] robot = new int[4][4];
	 int [][] robot1  = { {0,0,0},{0,1,0},{0,0,0} };
	 
//	 for ( int i = 0; i <3; i++)
//		 for(int j =0; j<3 j++)
			 
	 System.out.println(numberOfpaths(3,3,robot1));
		

	}

	private static int numberOfpaths(int i, int j, int[][]a) {
	
//	 if (i<0 || j<0)
//	 {
//		 return 0;
//	 }
//	if ( (i-1 == 1 || j-1 == 1) && a[i-1][j-1] == 0)
		if ( (i-1 == 1 || j-1== 1) && a[i-1][j-1] == 0)
		return 1;
		
		
	  int path = numberOfpaths(i,j-1,a) + numberOfpaths(i-1,j,a);
    //  if (a[i-1][j-1] == 0)
      //{
    	//  path++;
      //}
	  
      return path;
	}

}
