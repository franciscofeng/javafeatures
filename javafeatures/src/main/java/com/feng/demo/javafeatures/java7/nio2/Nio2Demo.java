package com.feng.demo.javafeatures.java7.nio2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Optional;
import java.util.Set;

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
		
//		StringBuilder sb = new StringBuilder();
//		
//		try(BufferedReader reader = Files.newBufferedReader(file))
//		{
//			String line = "";
//			while((line = reader.readLine()) != null)
//			{
//				sb.append(line);
//			}
//		}
//		return sb.toString();
		return new String(Files.readAllBytes(file));
		
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
	
	public void copyFileTo(String from,String to) throws IOException
	{
		Path fromPath = Paths.get(from);
		Path toPath = Paths.get(to);
		Files.copy(fromPath, toPath, StandardCopyOption.REPLACE_EXISTING);
	}
	
	public void addWritePermissionToAllUser(String file) throws IOException
	{
		Path path = Paths.get(file);
		PosixFileAttributes attrs = Files.readAttributes(path, PosixFileAttributes.class);
		Set<PosixFilePermission> permissions = attrs.permissions();
		permissions.add(PosixFilePermission.OTHERS_WRITE);
		Files.setPosixFilePermissions(path, permissions);
	}
	
	public String watchDirectory(String dir) throws IOException, InterruptedException
	{
		WatchService watch = FileSystems.getDefault().newWatchService();
		Path path = Paths.get(dir);
		WatchKey key = path.register(watch, StandardWatchEventKinds.ENTRY_DELETE);
		boolean run = true;
		String ret = null;
		
		while(run)
		{
			key = watch.take();
			for(WatchEvent<?> event:key.pollEvents())
			{
				if(event.kind() == StandardWatchEventKinds.ENTRY_DELETE)
				{
					ret = event.context().toString();
					run = false;
				}
			}
			key.reset();
		}
		return ret;
	}
	
	public void removeFile(String file) throws IOException
	{
		Path path = Paths.get(file);
		Files.delete(path);
	}
}
