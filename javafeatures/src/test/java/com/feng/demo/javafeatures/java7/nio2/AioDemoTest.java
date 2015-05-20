package com.feng.demo.javafeatures.java7.nio2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;

import junit.framework.TestCase;

public class AioDemoTest extends TestCase
{
	AioDemo demo;
	String fileName;
	String content;
	protected void setUp() throws Exception
	{
		super.setUp();
		demo = new AioDemo();
		content = "I love java world";
		String os = System.getProperty("os.name").toLowerCase();
		if (os.indexOf("win") >= 0)
		{
			this.fileName = "d:\\demo\\tmp\\aio.txt";
		} else if (os.indexOf("mac") >= 0)
		{
			this.fileName = "/var/tmp/demo/temp/aio.txt";
		}
		Path path = Paths.get(fileName);
		if (!Files.exists(path.getParent()))
		{
			Files.createDirectories(path.getParent());
		}
		if (Files.exists(path))
		{
			Files.delete(path);
		}
		Files.createFile(path);
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	public void testWriteToFile()
	{
		try
		{
			demo.writeToFile(fileName, content);
		} catch (IOException | InterruptedException | ExecutionException e)
		{
			fail();
		}
		
		Path path = Paths.get(fileName);
		String read = null;
		try
		{
			read = new String(Files.readAllBytes(path));
		} catch (IOException e)
		{
			fail();
		}
		assertEquals(content, read);
	}

	public void testReadFromFile()
	{
		String read = null;
		Path path = Paths.get(fileName);
		
		try
		{
			Files.write(path, content.getBytes(Charset.forName("UTF-8")));
			read = demo.readFromFile(fileName);
		} catch (IOException e)
		{
			fail();
		}
		assertEquals(content, read);
	}

}
