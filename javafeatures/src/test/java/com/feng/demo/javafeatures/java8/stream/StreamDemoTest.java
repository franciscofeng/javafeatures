package com.feng.demo.javafeatures.java8.stream;

import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

public class StreamDemoTest extends TestCase
{
	StreamDemo demo;
	String[] words = {"Alibaba","Google","Baidu","Boco"};
	protected void setUp() throws Exception
	{
		super.setUp();
		demo = new StreamDemo();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	public void testGetLongWordCount()
	{
		assertEquals(2,demo.getLongWordCount(words, 5));
	}

	public void testGetLongWordCountByParallel()
	{
		assertEquals(3,demo.getLongWordCountByParallel(words, 4));
	}

	public void testChangeFirstTwoWordToLowerCase()
	{
		String[] ret = demo.changeFirstTwoWordToLowerCase(words);
		assertEquals(2,ret.length);
		assertEquals("alibaba",ret[0]);
		assertEquals("google",ret[1]);
	}

	public void testGetNinetyNine()
	{
		assertEquals(99,demo.getNinetyNine());
	}

	public void testFindFirstWordWithCharactor()
	{
		assertEquals("Baidu",demo.findFirstWordWithCharactor(words, "B"));
	}

	public void testGetFirstTwoWords()
	{
		List<String> ret = demo.getFirstTwoWords(words);
		assertEquals("Alibaba",ret.get(0));
		assertEquals("Google",ret.get(1));
	}
	
	public void testSum()
	{
		Integer[] nums = {1,3,6,9};
		assertEquals(19,demo.sum(nums));
	}
	
	public void testGetWordLength()
	{
		Map<String,Integer> ret = demo.getWordLength(words);
		assertEquals(7,ret.get("Alibaba").intValue());
		assertEquals(6,ret.get("Google").intValue());
		assertEquals(5,ret.get("Baidu").intValue());
		assertEquals(4,ret.get("Boco").intValue());
	}
	
	public void testGroupWordsByLength()
	{
		String[] test = {"Plcm","Google","Baidu","Boco"};
		
		Map<Integer,List<String>> ret = demo.groupWordsByLength(test);
		assertEquals(1,ret.get(5).size());
		assertEquals("Baidu",ret.get(5).get(0));
		
		assertEquals(1,ret.get(6).size());
		assertEquals("Google",ret.get(6).get(0));
		
		assertEquals(2,ret.get(4).size());
		assertEquals("Plcm",ret.get(4).get(0));
		assertEquals("Boco",ret.get(4).get(1));
	}

}
