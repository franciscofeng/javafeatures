package com.feng.demo.javafeatures.java7.nio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class Nio2Demo
{
	public void createFileWithContent(String absolutePath,String content) throws IOException
	{
		Path path = Paths.get(absolutePath);
		if(!Files.exists(path.getParent()))
		{
			Files.createDirectories(path.getParent());
		}
		if(!Files.exists(path))
		{
			Files.createFile(path);
		}
		Files.write(path, content.getBytes());
	}
	
	public String readTextFromPath(String directory,String fileName) throws IOException
	{
		Path path = Paths.get(directory);
		Path file = path.resolve(fileName);
		if(!Files.exists(file))
		{
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		
		try(BufferedReader reader = Files.newBufferedReader(file))
		{
			String line = "";
			while((line = reader.readLine()) != null)
			{
				sb.append(line);
			}
		}
		return sb.toString();
		
	}
	
	public String findFileInDirectory(String directory,String fileName) throws IOException
	{
		Path dir = Paths.get(directory);
		if(!Files.exists(dir))
		{
			return "";
		}
		Optional<Path> op = Files.walk(dir, FileVisitOption.FOLLOW_LINKS).filter(p -> p.getName(p.getNameCount()-1).toString().equals(fileName)).findFirst();
		if(op.isPresent())
		{
			return op.get().toAbsolutePath().toString();
		}
		return "";
	}
	
	
}
