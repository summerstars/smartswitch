// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 

package com.smartswitch.common;

import com.broadlink.switchproduct.db.dao.ManageDeviceDao;
import com.broadlink.switchproduct.db.data.ManageDevice;
import java.sql.SQLException;
import java.util.List;

public class DeviceUnit
{

	public DeviceUnit()
	{
	}

	public static ManageDevice getMangeDevice(List list, String s)
	{
		int i = 0;
_L6:
		if (i < list.size()) goto _L2; else goto _L1
_L1:
		ManageDevice managedevice = null;
_L4:
		return managedevice;
_L2:
		managedevice = (ManageDevice)list.get(i);
		if (managedevice.getDeviceMac().equals(s)) goto _L4; else goto _L3
_L3:
		i++;
		if (true) goto _L6; else goto _L5
_L5:
	}

	public static boolean isDeviceEqual(ManageDevice managedevice, ManageDevice managedevice1)
	{
		return managedevice.getDeviceName().equals(managedevice1.getDeviceName()) && managedevice.getDeviceLock().equals(managedevice1.getDeviceLock()) && managedevice.getDevicePassword().equals(managedevice1.getDevicePassword());
	}

	public static void updateDBDevice(ManageDeviceDao managedevicedao, ManageDevice managedevice)
	{
		ManageDevice managedevice1;
		managedevice1 = managedevicedao.getDeviceByMac(managedevice.getDeviceMac());
		if (isDeviceEqual(managedevice1, managedevice))
			break MISSING_BLOCK_LABEL_88;
		if (!managedevice.getDeviceLock().equals("01"))
			break MISSING_BLOCK_LABEL_66;
		managedevice1.setDeviceLock("01");
		managedevice1.setDevicePassword(managedevice1.getDevicePassword());
_L2:
		managedevice1.setLocalIp(managedevice.getLocalIp());
		managedevice1.setDeviceName(managedevice.getDeviceName());
		managedevicedao.createOrUpdate(managedevice1);
		return;
		managedevice1.setDevicePassword(managedevice.getDevicePassword());
		managedevice1.setDeviceLock("00");
		if (true) goto _L2; else goto _L1
_L1:
		SQLException sqlexception;
		sqlexception;
		sqlexception.printStackTrace();
	}

	public static void updateMangeList(List list, ManageDevice managedevice)
	{
		int i = 0;
		do
		{
			if (i >= list.size())
				return;
			ManageDevice managedevice1 = (ManageDevice)list.get(i);
			if (managedevice1.getDeviceMac().equals(managedevice.getDeviceMac()))
			{
				managedevice1.setGetTime(managedevice.getGetTime());
				managedevice1.setLocalIp(managedevice.getLocalIp());
				managedevice1.setDeviceName(managedevice.getDeviceName());
				managedevice1.setDeviceLock(managedevice.getDeviceLock());
				managedevice1.setOnline(true);
				managedevice1.setLocal(managedevice.isLocal());
				if (managedevice.getDeviceLock().equals("01"))
				{
					managedevice1.setDeviceLock("01");
					managedevice1.setDevicePassword(managedevice1.getDevicePassword());
					return;
				} else
				{
					managedevice1.setDevicePassword(managedevice.getDevicePassword());
					managedevice1.setDeviceLock("00");
					return;
				}
			}
			i++;
		} while (true);
	}
}
