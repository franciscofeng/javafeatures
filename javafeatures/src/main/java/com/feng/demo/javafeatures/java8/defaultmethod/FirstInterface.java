package com.feng.demo.javafeatures.java8.defaultmethod;

public interface FirstInterface
{
	public void doSomething();
	default public int myDefaultMethod()
	{
		return 1;
	}
}
