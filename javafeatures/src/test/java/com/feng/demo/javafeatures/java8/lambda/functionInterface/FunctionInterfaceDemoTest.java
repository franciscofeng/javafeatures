package com.feng.demo.javafeatures.java8.lambda.functionInterface;

import junit.framework.TestCase;

public class FunctionInterfaceDemoTest extends TestCase
{
	FunctionInterfaceDemo demo;
	protected void setUp() throws Exception
	{
		super.setUp();
		demo = new FunctionInterfaceDemo();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	public void testContactString()
	{
		assertEquals("fengWIN", demo.contactString("feng", "win"));
	}

	public void testContactWithLowerCase()
	{
		assertEquals("Fengfeng", demo.contactWithLowerCase("Feng"));
	}

	public void testContactWithUperCase()
	{
		assertEquals("FengFENG",demo.contactWithUperCase("Feng"));
	}

	public void testSubstringWord()
	{
		assertEquals("cisco", demo.substringWord("Francisco"));
	}

	public void testToLowerCase()
	{
		assertEquals("plcm", demo.toLowerCase("PLCM"));
	}

}
