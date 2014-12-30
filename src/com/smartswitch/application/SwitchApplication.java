// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 

package com.smartswitch.application;

import android.app.Activity;
import android.app.Application;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.smartswitch.common.Settings;
import com.smartswitch.db.data.ManageDevice;

public class SwitchApplication extends Application
{

	public static List LocalDeviceList = new ArrayList();
	private static final String TAG = "SwitchApplication";
	public static List mServerList = new ArrayList();
	public static int value;
	public List mActivityList;
	private ManageDevice mControlDevice;

	public SwitchApplication()
	{
		mActivityList = new ArrayList();
	}

	public void clearActivityList()
	{
		int i = 0;
		do
		{
			if (i >= mActivityList.size())
			{
				mActivityList.clear();
				return;
			}
			((Activity)mActivityList.get(i)).finish();
			i++;
		} while (true);
	}

	public void finish()
	{
		clearActivityList();
		System.gc();
		mServerList.clear();
	}

	public ManageDevice getmControlDevice()
	{
		return mControlDevice;
	}

	public void onCreate()
	{
		super.onCreate();
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {


			public void uncaughtException(Thread thread, Throwable throwable)
			{
				(new Thread(new Runnable() {

					public void run()
					{
						if (mActivityList.size() > 0)
						{
							finish();
							System.exit(0);
						}
					}

				})).start();
				Log.e(SwitchApplication.TAG, throwable.getMessage(), throwable);
			}

		});
		start();
	}

	public void setControlDevice(ManageDevice managedevice)
	{
		mControlDevice = managedevice;
	}

	public void start()
	{
		String s;
		if ("mounted".equals(Environment.getExternalStorageState()))
			s = (new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath()))).append(File.separator).append("switch").toString();
		else
			s = (new StringBuilder(String.valueOf(Environment.getDataDirectory().getPath()))).append("/data/").append("switch").toString();
		Settings.CACHE_PATH = (new StringBuilder(String.valueOf(s))).append("/cache").toString();
		Settings.APK_SAVE = (new StringBuilder(String.valueOf(s))).append("/upd").toString();
		(new File(Settings.CACHE_PATH)).mkdirs();
		(new File(Settings.CACHE_PATH, ".nomedia")).mkdir();
		(new File(Settings.APK_SAVE)).mkdirs();
	}


}
