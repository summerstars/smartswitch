// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 

package com.smartswitch.common;

import java.io.*;

public class FileUtils
{

	public FileUtils()
	{
	}

	public static final boolean copyFile(File file, File file1)
	{
		if (file.exists()) goto _L2; else goto _L1
_L1:
		return false;
_L2:
		BufferedInputStream bufferedinputstream;
		BufferedOutputStream bufferedoutputstream;
		bufferedinputstream = null;
		bufferedoutputstream = null;
		BufferedInputStream bufferedinputstream1;
		file1.getParentFile().mkdirs();
		file1.createNewFile();
		bufferedinputstream1 = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bufferedoutputstream1 = new BufferedOutputStream(new FileOutputStream(file1));
		byte abyte0[] = new byte[1024];
_L3:
		int i = bufferedinputstream1.read(abyte0, 0, abyte0.length);
		if (i != -1)
			break MISSING_BLOCK_LABEL_113;
		bufferedoutputstream1.flush();
		IOException ioexception;
		if (bufferedoutputstream1 != null)
			try
			{
				bufferedoutputstream1.close();
			}
			catch (IOException ioexception6)
			{
				ioexception6.printStackTrace();
			}
		if (bufferedinputstream1 != null)
			try
			{
				bufferedinputstream1.close();
			}
			catch (IOException ioexception5)
			{
				ioexception5.printStackTrace();
			}
		return true;
		bufferedoutputstream1.write(abyte0, 0, i);
		  goto _L3
		ioexception;
		bufferedoutputstream = bufferedoutputstream1;
		bufferedinputstream = bufferedinputstream1;
_L7:
		ioexception.printStackTrace();
		if (bufferedoutputstream != null)
			try
			{
				bufferedoutputstream.close();
			}
			catch (IOException ioexception4)
			{
				ioexception4.printStackTrace();
			}
		if (bufferedinputstream == null) goto _L1; else goto _L4
_L4:
		try
		{
			bufferedinputstream.close();
		}
		catch (IOException ioexception3)
		{
			ioexception3.printStackTrace();
		}
		return false;
		Exception exception;
		exception;
_L6:
		if (bufferedoutputstream != null)
			try
			{
				bufferedoutputstream.close();
			}
			catch (IOException ioexception2)
			{
				ioexception2.printStackTrace();
			}
		if (bufferedinputstream != null)
			try
			{
				bufferedinputstream.close();
			}
			catch (IOException ioexception1)
			{
				ioexception1.printStackTrace();
			}
		throw exception;
		exception;
		bufferedinputstream = bufferedinputstream1;
		bufferedoutputstream = null;
		continue; /* Loop/switch isn't completed */
		exception;
		bufferedoutputstream = bufferedoutputstream1;
		bufferedinputstream = bufferedinputstream1;
		if (true) goto _L6; else goto _L5
_L5:
		ioexception;
		bufferedinputstream = null;
		bufferedoutputstream = null;
		  goto _L7
		ioexception;
		bufferedinputstream = bufferedinputstream1;
		bufferedoutputstream = null;
		  goto _L7
	}

	public static final String getFileFullNameByPath(String s)
	{
		String s1 = null;
		if (s != null)
		{
			int i = s.lastIndexOf(File.separator);
			int j;
			if (i == -1)
				j = 0;
			else
				j = i + 1;
			s1 = s.substring(j);
		}
		return s1;
	}

	public static final String getFileFullNameByUrl(String s)
	{
		String s1 = null;
		if (s != null)
		{
			int i = s.lastIndexOf("/");
			int j = s.lastIndexOf("?");
			int k;
			if (i == -1)
				k = 0;
			else
				k = i + 1;
			if (j == -1)
				j = s.length();
			s1 = s.substring(k, j);
		}
		return s1;
	}

	public static final String getFileNameByPath(String s)
	{
		String s1 = null;
		if (s != null)
		{
			int i = s.lastIndexOf(File.separator);
			int j = s.lastIndexOf(".");
			int k;
			if (i == -1)
				k = 0;
			else
				k = i + 1;
			if (j == -1)
				j = s.length();
			s1 = s.substring(k, j);
		}
		return s1;
	}

	public static final String getFileNameByUrl(String s)
	{
		String s1 = null;
		if (s != null)
		{
			int i = s.lastIndexOf("/");
			int j = s.lastIndexOf(".");
			int k = s.lastIndexOf("?");
			int l;
			if (i == -1)
				l = 0;
			else
				l = i + 1;
			if (j == -1)
			{
				if (k == -1)
					k = s.length();
			} else
			{
				k = j;
			}
			s1 = s.substring(l, k);
		}
		return s1;
	}

	public static final String getFileTypeByPath(String s)
	{
		String s1 = null;
		if (s != null)
		{
			int i = s.lastIndexOf(".");
			s1 = null;
			if (i != -1)
				s1 = s.substring(i + 1);
		}
		return s1;
	}

	public static final String getFileTypeByUrl(String s)
	{
		String s1 = null;
		if (s != null)
		{
			int i = s.lastIndexOf(".");
			int j = s.lastIndexOf("?");
			s1 = null;
			if (i != -1)
			{
				int k = i + 1;
				if (j == -1)
					j = s.length();
				s1 = s.substring(k, j);
			}
		}
		return s1;
	}

	public static final boolean saveBytesToFile(byte abyte0[], File file)
	{
		if (abyte0 != null) goto _L2; else goto _L1
_L1:
		return false;
_L2:
		ByteArrayInputStream bytearrayinputstream;
		BufferedOutputStream bufferedoutputstream;
		bytearrayinputstream = null;
		bufferedoutputstream = null;
		ByteArrayInputStream bytearrayinputstream1;
		file.getParentFile().mkdirs();
		file.createNewFile();
		bytearrayinputstream1 = new ByteArrayInputStream(abyte0);
		BufferedOutputStream bufferedoutputstream1 = new BufferedOutputStream(new FileOutputStream(file));
		byte abyte1[] = new byte[1024];
_L3:
		int i = bytearrayinputstream1.read(abyte1, 0, abyte1.length);
		if (i != -1)
			break MISSING_BLOCK_LABEL_103;
		bufferedoutputstream1.flush();
		IOException ioexception;
		if (bufferedoutputstream1 != null)
			try
			{
				bufferedoutputstream1.close();
			}
			catch (IOException ioexception6)
			{
				ioexception6.printStackTrace();
			}
		if (bytearrayinputstream1 != null)
			try
			{
				bytearrayinputstream1.close();
			}
			catch (IOException ioexception5)
			{
				ioexception5.printStackTrace();
			}
		return true;
		bufferedoutputstream1.write(abyte1, 0, i);
		  goto _L3
		ioexception;
		bufferedoutputstream = bufferedoutputstream1;
		bytearrayinputstream = bytearrayinputstream1;
_L7:
		ioexception.printStackTrace();
		if (bufferedoutputstream != null)
			try
			{
				bufferedoutputstream.close();
			}
			catch (IOException ioexception4)
			{
				ioexception4.printStackTrace();
			}
		if (bytearrayinputstream == null) goto _L1; else goto _L4
_L4:
		try
		{
			bytearrayinputstream.close();
		}
		catch (IOException ioexception3)
		{
			ioexception3.printStackTrace();
		}
		return false;
		Exception exception;
		exception;
_L6:
		if (bufferedoutputstream != null)
			try
			{
				bufferedoutputstream.close();
			}
			catch (IOException ioexception2)
			{
				ioexception2.printStackTrace();
			}
		if (bytearrayinputstream != null)
			try
			{
				bytearrayinputstream.close();
			}
			catch (IOException ioexception1)
			{
				ioexception1.printStackTrace();
			}
		throw exception;
		exception;
		bytearrayinputstream = bytearrayinputstream1;
		bufferedoutputstream = null;
		continue; /* Loop/switch isn't completed */
		exception;
		bufferedoutputstream = bufferedoutputstream1;
		bytearrayinputstream = bytearrayinputstream1;
		if (true) goto _L6; else goto _L5
_L5:
		ioexception;
		bytearrayinputstream = null;
		bufferedoutputstream = null;
		  goto _L7
		ioexception;
		bytearrayinputstream = bytearrayinputstream1;
		bufferedoutputstream = null;
		  goto _L7
	}
}
