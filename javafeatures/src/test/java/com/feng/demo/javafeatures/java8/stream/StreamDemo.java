package com.feng.demo.javafeatures.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo
{
	public long getLongWordCount(String[] words,int length)
	{
		List<String> wordList = Arrays.asList(words);
		long count = wordList.stream().filter(w -> w.length() > length).count();
		return count;
	}
	
	public long getLongWordCountByParallel(String[] words,int length)
	{
		List<String> wordList = Arrays.asList(words);
		long count = wordList.parallelStream().filter(w -> w.length() > length).count();
		return count;
	}
	
	public String[] changeFirstTwoWordToLowerCase(String[] words)
	{
		return Arrays.stream(words, 0, 1).map(String::toLowerCase).toArray(String[]::new);
	}
	
	public long getNinetyNine()
	{
		return Stream.generate(Math::random).limit(100).skip(1).count();
	}
	
	public String findFirstWordWithCharactor(String[] words,String charactor)
	{
		Optional<String> optional = Stream.of(words).filter(w -> w.startsWith(charactor)).findFirst();
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
		{
			return "";
		}
	}
	
	public List<String> getFirstTwoWords(String[] words)
	{
		return Arrays.asList(words).stream().limit(2).peek(System.out :: println).collect(Collectors.toList());
	}
}
