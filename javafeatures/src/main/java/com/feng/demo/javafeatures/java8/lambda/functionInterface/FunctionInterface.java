package com.feng.demo.javafeatures.java8.lambda.functionInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionInterface
{
	public static String handleBySupplier(String str,Supplier<String> supplier)
	{
		return str+supplier.get();
	}
	
	public static String handleByFunction(String str,Function<String,String> func)
	{
		return str+func.apply(str);
	}
	
	public static String handleByOperator(String str,UnaryOperator<String> op)
	{
		return str+op.apply(str);
	}
	
	public static String handleByPredicate(String str,Predicate<String> pre)
	{
		boolean flag = pre.test(str);
		if(flag)
		{
			return str;
		}
		return str.substring(4);
	}
	
	public static String handleByConsumer(String str,Consumer<String[]> cons)
	{
		String[] strs = new String[1];
		strs[0] = str;
		cons.accept(strs);
		return strs[0];
	}
}
