package com.feng.demo.javafeatures.java8.defaultmethod;

import junit.framework.TestCase;

public class OneInterfaceDemoTest extends TestCase
{
	OneInterfaceDemo demo;
	protected void setUp() throws Exception
	{
		super.setUp();
		demo = new OneInterfaceDemo();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}
	
	public void testMyDefaultMethod()
	{
		assertEquals(1,demo.myDefaultMethod());
	}
	
}
