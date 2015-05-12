package com.feng.demo.javafeatures.java8.newdatetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DateTimeDemo
{
	public boolean isPastDate(int year,int month,int day)
	{
		LocalDate now = LocalDate.now();
		LocalDate date = LocalDate.of(year, month, day);
		return now.isAfter(date);
	}
	
	public int getNextLeapYear()
	{
		LocalDate now = LocalDate.now();
		if(now.isLeapYear())
		{
			return now.getYear();
		}
		for(int i=1;i<5;i++)
		{
			LocalDate newYear = now.plusYears(i);
			if(newYear.isLeapYear())
			{
				return newYear.getYear();
			}
		}
		return 0;
	}
	
	public int getNextYearWeekDay(int year,int month,int day)
	{
		LocalDate date = LocalDate.of(year, month, day);
		LocalDate nextYear = date.plusYears(1);
		return nextYear.getDayOfWeek().getValue();
	}
	
	public int getDaysBetweenTwoDays(int firstyear, int firstmonth,
			int firstday, int secondyear, int secondmonth, int secondday)
	{
		LocalDate first = LocalDate.of(firstyear, firstmonth, firstday);
		LocalDate second = LocalDate.of(secondyear, secondmonth, secondday);
		Period period = Period.between(first, second);
		return period.getDays();
	}
	
	public long getTenSecond(long longtime)
	{
		Instant instant = Instant.ofEpochMilli(longtime);
		Instant tenSecInstant = instant.plusSeconds(10);
		Duration d = Duration.between(instant, tenSecInstant);
		return d.getSeconds();
	}
	
	public String dateTimeFormat(int year,int month,int day,int hour,int minute,int second)
	{
		LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute, second);
		return dateTime.format(DateTimeFormatter.ofPattern("uuuu -- MM -- dd :: HH-mm-ss"));
	}
	
	public long getHoursBetweenTokyoAndLocal()
	{
		ZonedDateTime local = ZonedDateTime.now(ZoneId.systemDefault());
		ZonedDateTime tokyo = ZonedDateTime.of(local.getYear(),
				local.getMonthValue(), local.getDayOfMonth(), local.getHour(),
				local.getMinute(), local.getSecond(), local.getNano(), ZoneId.of("Asia/Tokyo"));
		Duration d = Duration.between(tokyo, local);
		return d.getSeconds()/3600;
	}
	
	public int getFirstSunday(int year,int month)
	{
		LocalDate date = LocalDate.of(year, month, 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
		return date.getDayOfMonth();
	}
	
	public int getFirstDayOfWeek(int year,int month)
	{
		LocalDate date = LocalDate.of(year, month, 1).with(TemporalAdjusters.firstDayOfMonth());
		return date.getDayOfWeek().getValue();
	}
	
	public static void main(String[] args)
	{
		for(String str :ZoneId.getAvailableZoneIds())
		{
			System.out.println(str);
		}
	}
}
