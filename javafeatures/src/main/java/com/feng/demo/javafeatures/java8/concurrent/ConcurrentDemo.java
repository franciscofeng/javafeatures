package com.feng.demo.javafeatures.java8.concurrent;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.StampedLock;

public class ConcurrentDemo
{
	public long sumByLongAdder(long first,long second,long third)
	{
		LongAdder adder = new LongAdder();
		adder.add(first);
		adder.add(second);
		adder.add(third);
		adder.increment();//++
		adder.decrement();//--
		return adder.sum();
	}
	
	public Set<String> createConcurrentSet(String[] strs)
	{
		Set<String> ret = ConcurrentHashMap.newKeySet();
		ret.addAll(Arrays.asList(strs));
		return ret;
	}
	
	public Map<String,Integer> increaseNumIfKeyStartByA(String firstKey,
			int firstValue, String secondKey, int secondValue, String thirdKey,
			int thirdValue)
	{
		ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<String, Integer>();
		map.put(firstKey, firstValue);
		map.put(secondKey, secondValue);
		map.put(thirdKey, thirdValue);
		ConcurrentHashMap<String,Integer> ret = new ConcurrentHashMap<String,Integer>();
		map.forEach(1L, (k, v) -> k.startsWith("a") ? k : null,
				k -> ret.put(k, map.get(k).intValue()+1));
		return ret;
	}
	public int[] getThreeValues(int initValue,int addValue,int addValueWhenFive)
	{
		int[] ret = new int[3];
		LockDemo demo = new LockDemo(initValue);
		ret[0] = demo.read();
		ret[1] = demo.add(addValue);
		ret[2] = demo.addWhenValueLessThanFive(addValueWhenFive);
		return ret;
		
	}
	private String readFileMock()
	{
		//mock read file operation
		try
		{
			Thread.sleep(500);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return "Hello Java World";
	}
	
	public String[] readAndSplitFile()
	{
		CompletableFuture<String[]> future = CompletableFuture.supplyAsync(() -> readFileMock()).thenApplyAsync(w -> w.split(" "));
		String[] ret = null;
		try
		{
			ret = future.get();
		} catch (InterruptedException | ExecutionException e)
		{
			e.printStackTrace();
		}
		return ret;
	}
	private class LockDemo{
		private int value;
		private final StampedLock lock = new StampedLock();
		
		LockDemo(int initValue)
		{
			this.value = initValue;
		}
		
		public int add(int v)
		{
			long stamp = lock.writeLock();
			try
			{
				value += v;
				return value;
			} 
			finally
			{
				lock.unlock(stamp);
			}
		}
		
		public int read()
		{
			int ret = 0;
			long stamp = lock.tryOptimisticRead();
			ret = value;
			if(!lock.validate(stamp))
			{
				stamp = lock.readLock();
				try
				{
					ret = value;
				}
				finally
				{
					lock.unlockRead(stamp);
				}
			}
			return ret;
		}
		
		public int addWhenValueLessThanFive(int v)
		{
			long stamp = lock.tryOptimisticRead();
			try{
				while(value <= 5L)
				{
					long s = lock.tryConvertToWriteLock(stamp);
					if(s != 0L)
					{
						stamp = s;
						value += v;
						return value;
					}
					else
					{
//						lock.unlockRead(stamp);
						stamp = lock.writeLock();
					}
				}
				return value;
			}
			finally
			{
				lock.unlock(stamp);
			}
		}
	}
}
