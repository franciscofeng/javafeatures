package com.feng.demo.javafeatures.java7.coin;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class CoinDemo
{
	public void twr(GlobalContext context)
	{
		try (ResourceDemo demo = new ResourceDemo(context))
		{
			System.out.println("do someting here.");
		} catch (Exception e)
		{
			System.err.println("auto close failed");
		}
	}
	
	public void reflectionException(String className) throws ReflectiveOperationException
	{
		Method method;
		try
		{
			Class<?> clazz = Class.forName(className);
			method = clazz.getDeclaredMethod("sayHello");
			method.invoke(clazz.newInstance());
		} catch (ReflectiveOperationException e)
		{
			throw e;
		} 
	}
	
	public String invokeMethodByHandle()
	{
		String ret = null;
		try
		{
			MethodHandle handle =  MethodHandles.lookup().findStatic(ResourceDemo.class, "getString", MethodType.methodType(String.class));
			ret = (String)handle.invoke();
		} catch (Throwable e)
		{
			e.printStackTrace();
		}
		return ret;
	}
}
