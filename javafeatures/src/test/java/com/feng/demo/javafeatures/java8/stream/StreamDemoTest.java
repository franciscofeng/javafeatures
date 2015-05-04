package com.feng.demo.javafeatures.java8.stream;

import java.util.List;

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

}
