package com.feng.demo.javafeatures.java8.concurrent;

import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

public class ConcurrentDemoTest extends TestCase
{
	ConcurrentDemo demo;
	protected void setUp() throws Exception
	{
		super.setUp();
		demo = new ConcurrentDemo();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	public void testSumByLongAdder()
	{
		assertEquals(6, demo.sumByLongAdder(1, 2, 3));
	}

	public void testCreateConcurrentSet()
	{
		String[] strs = {"a","b"};
		Set<String> set = demo.createConcurrentSet(strs);
		assertEquals(2, set.size());
		set.add("c");
		assertEquals(3, set.size());
		set.add("c");
		assertEquals(3, set.size());
	}

	public void testIncreaseNumIfKeyStartByA()
	{
		Map<String,Integer> map = demo.increaseNumIfKeyStartByA("alibaba", 1, "baidu", 3, "amazon", 5);
		assertEquals(2, map.size());
		assertEquals(2, map.get("alibaba").intValue());
		assertEquals(6, map.get("amazon").intValue());
	}

	public void testGetThreeValues()
	{
		int[] ret = demo.getThreeValues(3, 1, 5);
		assertEquals(3,ret[0]);
		assertEquals(4, ret[1]);
		assertEquals(9, ret[2]);
	}
	
	public void testReadAndSplitFile()
	{
		String[] ret = demo.readAndSplitFile();
		assertEquals(3, ret.length);
		assertEquals("Hello", ret[0]);
		assertEquals("Java", ret[1]);
		assertEquals("World", ret[2]);
	}

}
