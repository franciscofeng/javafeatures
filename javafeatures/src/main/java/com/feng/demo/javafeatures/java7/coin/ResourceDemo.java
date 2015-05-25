package com.feng.demo.javafeatures.java7.coin;

public class ResourceDemo implements AutoCloseable
{
	private GlobalContext context;
	
	public ResourceDemo(GlobalContext context)
	{
		this.context = context;
	}
	
	public ResourceDemo()
	{
		
	}
	
	@Override
	public void close() throws Exception
	{
		System.out.println("resource is closed");
		if(context != null)
		{
			context.msg = "close";
		}
	}
	
	public static String getString()
	{
		return "hello";
	}

}
