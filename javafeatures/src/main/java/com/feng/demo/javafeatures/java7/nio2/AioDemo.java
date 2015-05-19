package com.feng.demo.javafeatures.java7.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AioDemo
{
	public void writeToFile(String file, String content) throws IOException,
			InterruptedException, ExecutionException
	{
		Path path = Paths.get(file);
		AsynchronousFileChannel afc = null;
		try
		{
			afc = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

			ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
			Future<Integer> future = afc.write(buffer, 0);
			while (!future.isDone())
			{
				Thread.sleep(10);
			}
			System.out.println("write to file done! size is:" + future.get());
		} finally
		{
			afc.close();
		}

	}

	public String readFromFile(String file) throws IOException
	{
		Path path = Paths.get(file);
		AsynchronousFileChannel afc = null;
		StringBuilder sb = new StringBuilder();
		try
		{
			ByteBuffer buffer = ByteBuffer.allocate(100_000);
			afc = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
			afc.read(buffer, 0, "test attachment",
					new CompletionHandler<Integer, String>()
					{

						@Override
						public void completed(Integer result, String attachment)
						{
							System.out.println(attachment);
							sb.append(new String(buffer.array()));
						}

						@Override
						public void failed(Throwable exc, String attachment)
						{
							System.err.println("fail");
						}
					});
			try
			{
				Thread.sleep(5000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}

		} finally
		{
			afc.close();
		}

		return sb.toString();
	}
}
