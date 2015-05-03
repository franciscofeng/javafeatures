package com.feng.demo.javafeatures.java8.defaultmethod;

public class TwoInterfacesDemo implements FirstInterface, SecondInterface
{

	@Override
	public void trySometing()
	{
		System.out.println("no use");
	}

	@Override
	public void doSomething()
	{
		System.out.println("no use");
	}

	@Override
	public int myDefaultMethod()
	{
		return 3;
	}
}
