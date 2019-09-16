package Session_yash;

// check for array declaration
import java.util.Scanner;

public class Line_cross {

	private static int intrs = 0;

	public static void main(String[] args) {

		int[][] v = new int[100][3];
		int[][] h = new int[100][3];

		Scanner sc = new Scanner(System.in);
		int ver = Integer.parseInt(sc.nextLine());
		int hori = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < ver; i++) {
			String[] arr = sc.nextLine().split("\\s+");
			for (int j = 0; j < 3; j++) {

				v[i][j] = Integer.parseInt(arr[j]);

			}

		}

		for (int i = 0; i < hori; i++) {
			String[] arr = sc.nextLine().split("\\s+");
			for (int j = 0; j < 3; j++) {

				h[i][j] = Integer.parseInt(arr[j]);

			}

		}

//	   for (int[] m : v)
//	   {
//		    for (int n : m)
//		    {
//		     System.out.print(n+" ");
//		    }
//		   
//		System.out.println();    
//	   }
//	 

		for (int i = 0; i < hori; i++) {

			for (int j = 0; j < ver; j++) {

				if ((h[i][1] <= v[j][0]) && (v[j][0] <= h[i][2]) && (v[j][1] <= h[i][0]) && (h[i][0] <= v[j][2]))
					intrs++;

			}
		}
		
       System.out.println(intrs);
	}

}
