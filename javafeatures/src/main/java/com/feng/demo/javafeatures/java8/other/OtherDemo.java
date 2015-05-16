package com.feng.demo.javafeatures.java8.other;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class OtherDemo
{
	public String getLinuxPath(String...strings)
	{
		return String.join("/", strings);
	}
	
	public double doubleSum(double d1,double d2)
	{
		return Double.sum(d1, d2);
	}
	
	public long multiplyAndMod(long l1,long l2,long mod)
	{
		long result = Math.multiplyExact(l1, l2);
		result = Math.floorMod(result, mod);
		return result;
	}
	
	public Map<Integer,String> getMapWithBiggerKey(Map<Integer,String> map,int key)
	{
		NavigableMap<Integer, String> nmap = new ConcurrentSkipListMap<Integer, String>(map);
		return nmap.tailMap(key);
	}
	
	public String getBase64Code(String source)
	{
		return Base64.getEncoder().encodeToString(source.getBytes(StandardCharsets.UTF_8));
	}
}
