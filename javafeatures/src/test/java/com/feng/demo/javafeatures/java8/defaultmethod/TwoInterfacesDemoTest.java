package com.feng.demo.javafeatures.java8.defaultmethod;

import junit.framework.TestCase;

public class TwoInterfacesDemoTest extends TestCase
{
	TwoInterfacesDemo demo;
	protected void setUp() throws Exception
	{
		super.setUp();
		demo = new TwoInterfacesDemo();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	public void testMyDefaultMethod()
	{
		assertEquals(3,demo.myDefaultMethod());
	}

}
