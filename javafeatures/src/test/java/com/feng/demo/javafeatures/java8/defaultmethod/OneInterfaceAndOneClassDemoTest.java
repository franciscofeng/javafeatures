package com.feng.demo.javafeatures.java8.defaultmethod;

import junit.framework.TestCase;

public class OneInterfaceAndOneClassDemoTest extends TestCase
{

	OneInterfaceAndOneClassDemo demo;
	protected void setUp() throws Exception
	{
		super.setUp();
		demo = new OneInterfaceAndOneClassDemo();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}
	
	public void testMyDefaultMethod()
	{
		assertEquals(0,demo.myDefaultMethod());
	}
	
}
