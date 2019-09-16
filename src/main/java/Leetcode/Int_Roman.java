package Leetcode;

//import java.util.LinkedHashMap;
import java.util.Scanner;

public class Int_Roman {

	//private static LinkedHashMap<String,Integer> map = new LinkedHashMap<String,Integer>();

	public static void main(String[] args) {
		
		String m[] = {"", "M", "MM", "MMM"}; 
        String c[] = {"", "C", "CC", "CCC", "CD", "D",  
                            "DC", "DCC", "DCCC", "CM"}; 
        String x[] = {"", "X", "XX", "XXX", "XL", "L",  
                            "LX", "LXX", "LXXX", "XC"}; 
        String j[] = {"", "I", "II", "III", "IV", "V",  
                            "VI", "VII", "VIII", "IX"}; 
        
        Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int num = Integer.parseInt(str);
		      
        // Converting to roman 
        String thousands = m[num/1000]; 
        String hundereds = c[(num%1000)/100]; 
        String tens = x[(num%100)/10]; 
        String ones = j[num%10]; 
              
        String ans = thousands + hundereds + tens + ones; 
		
        System.out.println(ans);  
		
//		int len = str.length();
//		String  s_num4 =null;
//		String s_num3=null;
//		String s_num2=null;
//		String s_num1=null;
//
//
//		
//		map.put("I",1);
//		map.put("V",5);
//		map.put("X",10);
//		map.put("L",50);
//		map.put("C",100);
//		map.put("D",500);
//		map.put("M",1000);
//		
//	   if (len == 4)
//	   {
//		   
//		 int num3 = num %1000;
//		 int num2 = num3 % 100;
//		 int num1 = num2%10;		 
//		 
//		 int n_num4 = 1000;
//		 int n_num3 = (num3-num2);
//		 int n_num2 = (num2-num1);
//		 int n_num1 = num1;
//		// if (num3 ==) 
//		 
//		  
//		 
//		  System.out.println(n_num4+" "+n_num3+" "+n_num2+ " "+n_num1);
//		  
//		  
//		  if (n_num3==400)
//		  {
//			  s_num3 = "CD";
//		  }
//		
//		  if (n_num3==900)
//		  {
//			  s_num3 = "CM";
//		  }
//		 
//		  if (n_num2==40)
//		  {
//			  s_num2 = "XL";
//		  }
//		  if (n_num2==90)
//		  {
//			  s_num2 = "XC";
//		  }
//		  
//		  // check for modulo 2
//		  
//		  if (n_num2 % 10 ==2 || n_num2 %10==7)
//		  {
//			  
//			    if (n_num2 < 50)
//			    {
//			    int temp1 = n_num2/10;
//			    String X1 = "X";
//			      for (int i= 1 ; i<temp1; i++)
//			      {
//			       s_num2 = X1+ s_num2 ; 
//			      }
//			      
//			      if(n_num2 % 10 ==2)
//			      {
//			    	  s_num1 = "II";
//			    	  
//			      }
//			      if(n_num2 % 10 ==7)
//			      {
//			    	  s_num1="VII";
//			      }
//			      
//			      
//			    }
//			    
//			    if (n_num2 >=50)
//			    {
//			    int temp1 = n_num2 /50;
//			    int temp2 = n_num2-temp1;
//			    int temp3 = temp2/10;
//			    String X1 = "L";
//			    String X2 = "X";
//			      for (int i= 1 ; i<temp2; i++)
//			      {
//			       s_num2 = X1+ X2+ s_num2 ; 
//			      }
//			      
//			    }
//			    
//			    
//		  }
//		  
//		  
//		 
//		  if (n_num1==4)
//		  {
//			  s_num1 = "IV";
//		  }
//		  else if (n_num1==9)
//		  {
//			  s_num1 = "IX";
//		  }
//		
//		  System.out.println("M"+" "+s_num3+" "+s_num2+ " "+s_num1);
//	   }
		
	   
	  

	}

}
