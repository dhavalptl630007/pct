package com.practice.test.pct;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RationalTest2 {

	Rational a, b;

	@Before
	public void before() {
		a = new Rational(1, 2);
		b = new Rational(2, 3);
	}

	@Test
	public void test1() {
		Rational c = a.add(b);
		assertEquals(7, c.num());
		assertEquals(6, c.denum());
		Rational d = new Rational(7,6);
		boolean equalscd = c.equals(d);
		assertEquals(c,d);

		c = a.sub(b);
		assertEquals(-1, c.num());
		assertEquals(6, c.denum());

		c = a.mul(b);
		assertEquals(1, c.num());
		assertEquals(3, c.denum());

		c = a.div(b);
		assertEquals(3, c.num());
		assertEquals(4, c.denum());

		
	}
	
	@Test
	public void test2() {
		assertTrue(a.equals(a));
	}

}
