package com.feng.demo.javafeatures.java8.lambda;

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
	
	public int countStringLength()
	{
		int[] sum = new int[1];
		Arrays.asList(strArray).forEach(n -> sum[0] +=n.length());
		return sum[0];
	}
	
	public String getLongestWord()
	{
		LambdaStringHelper helper = new LambdaStringHelper(strArray, (first,
				last) ->
		{
			if (first.length() >= last.length())
				return first;
			else
				return last;
		});
		return helper.findString();
	}
	
	public String getShortestWord()
	{
		LambdaStringHelper helper = new LambdaStringHelper(strArray, (first,
				last) ->
		{
			if (first.length() <= last.length())
				return first;
			else
				return last;
		});
		return helper.findString();
	}
	
	public String getFirstOfArray()
	{
		LambdaStringHelper helper = new LambdaStringHelper(strArray,LambdaStringHelper::getFirstWord);
		return helper.findString();
	}
}

