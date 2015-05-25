package com.feng.demo.javafeatures.java6.annotation;

import junit.framework.TestCase;

public class BusinessDemoTest extends TestCase
{
	IBusiness demo;
	LogProxy proxy;

	protected void setUp() throws Exception
	{
		super.setUp();

		proxy = new LogProxy();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	public void testNeedManyParams()
	{
		demo = new BusinessDemo();
		IBusiness proxyDemo = (IBusiness) proxy.bindClass(demo);
		assertEquals("[name:feng][age:37][site:beijing][title:engineer]",
				proxyDemo.needManyParams("feng", 37, "beijing", "engineer"));

	}

}
