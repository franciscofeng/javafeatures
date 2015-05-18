package com.feng.demo.javafeatures.java7.nio2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import junit.framework.TestCase;

public class Nio2DemoTest extends TestCase
{
	Nio2Demo demo ;
	String rootDemoPath;
	String fileName;
	String fileFullName;
	String content;
	protected void setUp() throws Exception
	{
		super.setUp();
		demo = new Nio2Demo();
		String os = System.getProperty("os.name").toLowerCase();
		if(os.indexOf("win") >= 0)
		{
			this.rootDemoPath = "d:\\demo\\tmp";
		}else if(os.indexOf("mac") >=0)
		{
			this.rootDemoPath = "/var/tmp/demo/temp";
		}
		fileName = "test.txt";
		fileFullName = String.join(File.separator, rootDemoPath,fileName);
		content = "hello world!";
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	public void testCreateFileWithContent()
	{
		
		try
		{
			demo.createFileWithContent(fileFullName, content);
		} catch (IOException e)
		{
			fail();
		}
		assertEquals(true, Files.exists(Paths.get(fileFullName)));
		
	}

	public void testReadTextFromPath()
	{
		String readContent = null;
		try
		{
			readContent = demo.readTextFromPath(rootDemoPath, fileName);
		} catch (IOException e)
		{
			fail();
		}
		assertEquals(content,readContent);
	}

	public void testFindFileInDirectory()
	{
		String path = Paths.get(rootDemoPath).getParent().toString();
		try
		{
			assertEquals(this.fileFullName, demo.findFileInDirectory(path, fileName));
		} catch (IOException e)
		{
			fail();
		}
	}

}
