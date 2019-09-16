package Session_yash;

import java.util.Scanner;

public class Game_of_life {
	
  static int row =0;
  static int col =0;
  static int[][] curr;
  
  public static void main (String[] args) 
  {
  Scanner sc = new Scanner(System.in);
  row = Integer.parseInt(sc.nextLine());
  col = Integer.parseInt(sc.nextLine());
    
  
  int[][] input = new int[row][col];
  curr = new int[row+2][col+2];
  int[][] future = new int[row][col];
  
  for (int i = 0; i<row; i++)
  {
	  String[] arr = sc.nextLine().split("\\s+");
	  
	  for(int j = 0; j<col;j++)
	  {	
       	 input[i][j] = Integer.parseInt(arr[j]); 
       	 curr[i+1][j+1]= Integer.parseInt(arr[j]); 
       	 future[i][j]= input[i][j];
	  }
	
   }
  
  
  
//  for (int i = 0; i<row +2; i++)
//  {
//	  
//	  
//	  for(int j = 0; j<col+2;j++)
//	  {	
//      System.out.print(curr[i][j]+" ");
//  
//	  }
//  
//   System.out.println();	  
//  }
  
  int s = Integer.parseInt(sc.nextLine());
  
  for (int i = 0 ; i <s; i++)
  {
	  
	  simulate(curr);
	  System.out.println();
	  
  }
  
  }  
  
private static void simulate(int[][] curr) {

	for (int l = 1; l < row +1 ; l++)
	  {
	      for (int m = 1; m<col +1; m++)
	      {
	    	  
	         int neigh =0;
	         
	           for (int i = -1; i<=1;i++)
	        	for (int j = -1; j<=1;j++)
	        		neigh += curr[l+i][m+j]; 	
	    	    
	    	 neigh = neigh -curr[l][m];
	         // 1 or 0 die
	    	if (curr[l][m] ==1 && (neigh ==0 ||neigh==1)) 
	    	{
	    	    curr[l][m] = 0;
	    	}
	    	//>= 4 then die
	    	if (curr[l][m] ==1 && (neigh >= 4)) 
	    	{
	    	    curr[l][m] = 0;
	    	}
	    	//>= 2 or 3 then survive
	    	if (curr[l][m] ==1 && (neigh ==2 ||neigh==3)) 
	    	{
	    	    curr[l][m] = 1;
	    	}
	    	//empty
	    	if (curr[l][m] ==0 && (neigh == 3)) 
	    	{
	    	    curr[l][m] = 1;
	    	}
	    	
	    	
	      }
	  
	     }
	  
	    for (int i = 1; i <row+1;i++)
	    {
	    	for (int j = 1; j<col+1;j++)
	    	{
	    		 System.out.print(curr[i][j]+" ");
	    	}
	    	
	    	 System.out.println();	 
	    }
	  
	  
	  }

}	
