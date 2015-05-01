package com.feng.demo.javafeatures.java8;

import java.util.Arrays;

public class LambdaDemo
{
	private String[] strArray;
	
	public LambdaDemo(String[] strArray)
	{
		this.strArray = strArray;
	}
	
	public String[] sortByLength()
	{
		Arrays.sort(strArray, (first,last) -> first.length()-last.length());
		return strArray;
	}
}

