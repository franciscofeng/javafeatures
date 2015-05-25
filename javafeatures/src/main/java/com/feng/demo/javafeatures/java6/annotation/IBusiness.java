package com.feng.demo.javafeatures.java6.annotation;

public interface IBusiness
{
	public String needManyParams(@ParamName(name = "name") String name,
			@ParamName(name = "age") int age,
			@ParamName(name = "site") String site,
			@ParamName(name = "title") String title);
}
