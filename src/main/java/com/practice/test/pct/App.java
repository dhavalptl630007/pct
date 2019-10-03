package com.practice.test.pct;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        System.out.println(Math.round(705.9));
       
        long start = System.currentTimeMillis();
        
        List<String> al = new ArrayList<String>();
        
        for (int i = 0; i < 100000; i++) {
        	al.add("this");
		}
        
        long end = System.currentTimeMillis();
        
        System.out.println(end-start);
        
    }
}

class bodi
{
    
}
