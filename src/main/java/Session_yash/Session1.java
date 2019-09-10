package Session_yash;

import java.util.Scanner;

public class Session1 {
	
 public static void main (String [] args)
 {
 Scanner sc = new Scanner(System.in);
 String line = sc.nextLine();
 
 String arr[] = line.split("\\s+");
 
 String firstname = null;
 String middelname = null;
 String surname = null;
 String f_string = null;

 if (arr.length == 1)
 {
	 firstname = arr[0];
	 f_string = firstname;
 }
 else if (arr.length == 2) {
	 firstname = arr[0];
	 String temp = arr[1];
	 
	   
	 if ((temp.endsWith("a") ||
			 temp.endsWith("e") ||
			 temp.endsWith("i") ||
			 temp.endsWith("o") ||
			 temp.endsWith("u") ||
			 temp.endsWith("A") ||
			 temp.endsWith("E") ||
			 temp.endsWith("I") ||
			 temp.endsWith("O") ||
			 temp.endsWith("U") ) )
	 {
		 surname = temp;
	        f_string = surname+ " "+firstname;
      
       }
	 else
	 {
		  middelname = temp;
		f_string = firstname+ " "+middelname;
        
	 }
	 
	 
 } 
 
 else if (arr.length == 3)
 {
	 firstname = arr[0];
	  middelname = arr[1];
	  surname = arr[2];
	 f_string = surname+" "+firstname+" "+middelname;	 
	 
 }
 
  System.out.println(f_string.trim());
 
 }
}

