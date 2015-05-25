package com.feng.demo.javafeatures.java6.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;

public class LogProxy implements InvocationHandler
{
	private Object obj;
	
	public Object bindClass(Object object)
	{
		this.obj = object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object object, Method method, Object[] params)
			throws Throwable
	{
		StringBuilder sb = new StringBuilder();
		Parameter[] parameters = method.getParameters();
		for(int i=0;i<parameters.length;i++)
		{
			Parameter p = parameters[i];
			ParamName pn= p.getAnnotation(ParamName.class);
			sb.append("[");
			sb.append(pn.name());
			sb.append(":");
			sb.append(params[i]);
			sb.append("]");
		}
		Object ret = method.invoke(this.obj, params);
		System.out.println(ret);
		return sb.toString();
	}

}
