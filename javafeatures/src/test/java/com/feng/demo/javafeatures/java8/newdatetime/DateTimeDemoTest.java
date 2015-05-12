package com.feng.demo.javafeatures.java8.newdatetime;

import junit.framework.TestCase;

public class DateTimeDemoTest extends TestCase
{
	DateTimeDemo demo;
	protected void setUp() throws Exception
	{
		super.setUp();
		demo = new DateTimeDemo();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	public void testIsPastDate()
	{
		assertEquals(true, demo.isPastDate(2015, 5, 10));
	}

	public void testGetNextLeapYear()
	{
		assertEquals(2016, demo.getNextLeapYear());
	}

	public void testGetNextYearWeekDay()
	{
		assertEquals(4, demo.getNextYearWeekDay(2014, 12, 3));
	}

	public void testGetDaysBetweenTwoDays()
	{
		assertEquals(9, demo.getDaysBetweenTwoDays(2015, 4, 1, 2015, 4, 10));
	}

	public void testGetTenSecond()
	{
		assertEquals(10, demo.getTenSecond(System.currentTimeMillis()));
	}

	public void testDateTimeFormat()
	{
		assertEquals("2015 -- 05 -- 12 :: 17-42-00", demo.dateTimeFormat(2015, 5, 12, 17, 42, 0));
	}

	public void testGetHoursBetweenTokyoAndLocal()
	{
		assertEquals(1, demo.getHoursBetweenTokyoAndLocal());
	}

}
