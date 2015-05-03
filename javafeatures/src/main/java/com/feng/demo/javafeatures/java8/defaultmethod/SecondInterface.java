package com.feng.demo.javafeatures.java8.defaultmethod;

public interface SecondInterface
{
	public void trySometing();
	default public int myDefaultMethod()
	{
		return 2;
	}

}
