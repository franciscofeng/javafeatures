package com.feng.demo.javafeatures.java7.nio2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;

import junit.framework.TestCase;

public class Nio2DemoTest extends TestCase
{
	Nio2Demo demo ;
	String rootDemoPath;
	String fileName;
	String fileFullName;
	String content;
	String copyDir;
	String copyFileFullName;
	boolean isLinux = false;
	protected void setUp() throws Exception
	{
		super.setUp();
		demo = new Nio2Demo();
		String os = System.getProperty("os.name").toLowerCase();
		if(os.indexOf("win") >= 0)
		{
			this.rootDemoPath = "d:\\demo\\tmp";
			this.copyDir = "d:\\demo";
		}else if(os.indexOf("mac") >=0)
		{
			this.rootDemoPath = "/var/tmp/demo/temp";
			this.copyDir = "/var/tmp/demo";
			this.isLinux = true;
		}
		fileName = "test.txt";
		fileFullName = String.join(File.separator, rootDemoPath,fileName);
		copyFileFullName = String.join(File.separator,copyDir,"copy.txt");
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
	public void testCopyFileTo()
	{
		try
		{
			demo.copyFileTo(fileFullName, copyFileFullName);
			String read = demo.readTextFromPath(copyDir, "copy.txt");
			assertEquals(content, read);
		} catch (IOException e)
		{
			fail();
		}
	}

	public void testAddWritePermissionToAllUser()
	{
		if(isLinux)
		{
			try
			{
				demo.addWritePermissionToAllUser(copyFileFullName);

				Path path = Paths.get(copyFileFullName);
				assertTrue(Files
						.readAttributes(path, PosixFileAttributes.class)
						.permissions()
						.contains(PosixFilePermission.OTHERS_WRITE));
			} catch (IOException e)
			{
				fail();
			}
		}
			
	}

	public void testRemoveFile()
	{
		try
		{
			demo.removeFile(copyFileFullName);
		} catch (IOException e)
		{
			fail();
		}
		Path path = Paths.get(copyFileFullName);
		assertFalse(Files.exists(path));
	}
	
	public void testWatchDirectory()
	{
		Runnable runnable = new Runnable(){

			@Override
			public void run()
			{
				try
				{
					Thread.sleep(2000);
					demo.removeFile(fileFullName);
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
		};
		new Thread(runnable).start();
		String ret = null;
		try
		{
			ret = demo.watchDirectory(rootDemoPath);
		} catch (IOException | InterruptedException e)
		{
			fail();
		}
		assertEquals(fileName, ret);
		
	}


}
