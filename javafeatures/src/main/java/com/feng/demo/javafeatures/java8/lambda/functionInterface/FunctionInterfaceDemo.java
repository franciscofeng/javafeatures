package com.feng.demo.javafeatures.java8.lambda.functionInterface; 
public class FunctionInterfaceDemo
{
	public String contactString(String first,String second)
	{
		return FunctionInterface.handleBySupplier(first, () -> second.toUpperCase());
	}
	
	public String contactWithLowerCase(String word)
	{
		return FunctionInterface.handleByFunction(word, s -> s.toLowerCase());
	}
	
	public String contactWithUperCase(String word)
	{
		return FunctionInterface.handleByOperator(word, s -> s.toUpperCase());
	}
	
	public String substringWord(String word)
	{
		return FunctionInterface.handleByPredicate(word, s -> s.length()<4);
	}
	
	public String toLowerCase(String word)
	{
		return FunctionInterface.handleByConsumer(word, s -> s[0] = s[0].toLowerCase());
	}
	
}
