package com.practice.test.pct;


import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class RationalTest1{
	
  private static Rational spy1;
  
   @Before
   public void beforClass()
   {
	   spy1 = new Rational(-5,-10);
	   
   }
	
	@Test
	public void testNormalize(){
	 spy1.normalize();	
	 
	 assertEquals(5, spy1.num());
	 assertEquals(10, spy1.denum());
	 
	}
	
	@Test
	public void testReduce() {
		spy1.reduce();	
		
		 assertEquals(1, spy1.num());
		 assertEquals(2, spy1.denum());
		 
		
		
	}
	

}
