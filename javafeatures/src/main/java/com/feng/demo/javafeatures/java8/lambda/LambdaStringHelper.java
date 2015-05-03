package com.feng.demo.javafeatures.java8.lambda;

public class LambdaStringHelper
{
	private String[] strs;
	private ILambdaInterface lambda;
	
	public LambdaStringHelper(String[] strs,ILambdaInterface lambda)
	{
		this.strs = strs;
		this.lambda = lambda;
	}
	
	public final String findString()
	{
		String result = strs[0];
		for(String str:strs)
		{
			result = lambda.compareString(result, str);
		}
		return result;
	}
	
	public final static String getFirstWord(String first,String last)
	{
		return first;
	}
}
