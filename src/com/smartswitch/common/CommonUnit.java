// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 

package com.smartswitch.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CommonUnit
{

	public CommonUnit()
	{
	}

	public static boolean checkNetwork(Context context)
	{
		NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
		return networkinfo != null && networkinfo.isConnected();
	}

	public static boolean isWifiConnect(Context context)
	{
		return ((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
	}

	public static String toTime(int i, int j)
	{
		String s;
		String s1;
		if ((new StringBuilder(String.valueOf(i))).toString().length() == 1)
			s = (new StringBuilder("0")).append(i).toString();
		else
			s = (new StringBuilder(String.valueOf(i))).toString();
		if ((new StringBuilder(String.valueOf(j))).toString().length() == 1)
			s1 = (new StringBuilder("0")).append(j).toString();
		else
			s1 = (new StringBuilder(String.valueOf(j))).toString();
		return (new StringBuilder(String.valueOf(s))).append(":").append(s1).toString();
	}
}
