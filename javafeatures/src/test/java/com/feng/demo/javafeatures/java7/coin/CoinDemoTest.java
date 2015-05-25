package com.feng.demo.javafeatures.java7.coin;

import junit.framework.TestCase;

public class CoinDemoTest extends TestCase
{
	CoinDemo demo;
	protected void setUp() throws Exception
	{
		super.setUp();
		demo = new CoinDemo();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	public void testTwr()
	{
		GlobalContext context = new GlobalContext();
		context.msg = "test";
		demo.twr(context);
		assertEquals("close", context.msg);
	}

	public void testReflectionException()
	{
		try
		{
			demo.reflectionException("com.none.no.null");
			fail("do not throw exception");
		} catch (ReflectiveOperationException e)
		{
			assertEquals("com.none.no.null", e.getMessage());
		}
	}

	public void testInvokeMethodByHandle()
	{
		assertEquals("hello", demo.invokeMethodByHandle());
	}

}
