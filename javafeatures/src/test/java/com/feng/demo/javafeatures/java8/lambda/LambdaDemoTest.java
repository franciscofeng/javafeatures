package com.feng.demo.javafeatures.java8.lambda;

import com.feng.demo.javafeatures.java8.lambda.LambdaDemo;

import junit.framework.TestCase;

public class LambdaDemoTest extends TestCase
{
	LambdaDemo lambda;
	String[] strs = {"alibaba","google","baidu","boco"};
	protected void setUp() throws Exception
	{
		lambda = new LambdaDemo(strs);
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	public void testSortByLength()
	{
		String[] result = lambda.sortByLength();
		assertEquals("boco", result[0]);
		assertEquals("baidu", result[1]);
		assertEquals("google", result[2]);
		assertEquals("alibaba", result[3]);
	}
	public void testCountStringLength()
	{
		assertEquals(22,lambda.countStringLength());
	}
	public void testGetLongestWord()
	{
		assertEquals("alibaba",lambda.getLongestWord());
	}
	
	public void testGetShortestWord()
	{
		assertEquals("boco",lambda.getShortestWord());
	}
	
	public void testGetFirstOfArray()
	{
		assertEquals("alibaba",lambda.getFirstOfArray());
	}
}
