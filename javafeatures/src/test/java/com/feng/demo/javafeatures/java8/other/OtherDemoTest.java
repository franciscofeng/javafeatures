package com.feng.demo.javafeatures.java8.other;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class OtherDemoTest extends TestCase
{
	OtherDemo demo;
	protected void setUp() throws Exception
	{
		super.setUp();
		demo = new OtherDemo();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	public void testGetLinuxPath()
	{
		assertEquals("/var/log/feng", demo.getLinuxPath("/var","log","feng"));
	}

	public void testDoubleSum()
	{
		assertEquals(57.6d, demo.doubleSum(12.0d, 45.6d));
	}

	public void testMultiplyAndMod()
	{
		assertEquals(2L, demo.multiplyAndMod(13L, 2L, 4L));
	}

	public void testGetMapWithBiggerKey()
	{
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "alibaba");
		map.put(2, "baidu");
		map.put(3, "tencent");
		
		Map<Integer,String> ret = demo.getMapWithBiggerKey(map, 2);
		assertEquals(2, ret.size());
		assertEquals("baidu", ret.get(2));
		assertEquals("tencent", ret.get(3));
	}

	public void testGetBase64Code()
	{
		String codes = "aGVsbG8gamF2YSB3b3JsZA==";
		assertEquals(codes, demo.getBase64Code("hello java world"));
	}

}
