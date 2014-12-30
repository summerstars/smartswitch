/**
 * Device database
 */
/**
 * @author Lance
 *
 */

package com.smartswitch.db.data;

import java.io.Serializable;

public class ManageDevice
	implements Serializable
{

	private static final long serialVersionUID = 0x6926f1e1752fc6d4L;
	private String ServerIp;
	private int ServerPort;
	private int count;
	private String deviceIcon;
	private String deviceLock;
	private String deviceMac;
	private String deviceName;
	private String devicePassword;
	private String deviceType;
	private long getTime;
	private boolean isLocal;
	private String localIp;
	private String magic;
	private boolean online;
	private int switchStatus;
	private String timer;

	public ManageDevice()
	{
		isLocal = false;
		online = true;
	}

	public int getCount()
	{
		return count;
	}

	public String getDeviceIcon()
	{
		return deviceIcon;
	}

	public String getDeviceLock()
	{
		return deviceLock;
	}

	public String getDeviceMac()
	{
		return deviceMac;
	}

	public String getDeviceName()
	{
		return deviceName;
	}

	public String getDevicePassword()
	{
		return devicePassword;
	}

	public String getDeviceType()
	{
		return deviceType;
	}

	public long getGetTime()
	{
		return getTime;
	}

	public String getLocalIp()
	{
		return localIp;
	}

	public String getMagic()
	{
		return magic;
	}

	public String getServerIp()
	{
		return ServerIp;
	}

	public int getServerPort()
	{
		return ServerPort;
	}

	public int getSwitchStatus()
	{
		return switchStatus;
	}

	public String getTimer()
	{
		return timer;
	}

	public boolean isLocal()
	{
		return isLocal;
	}

	public boolean isOnline()
	{
		return online;
	}

	public void setCount(int i)
	{
		count = i;
	}

	public void setDeviceIcon(String s)
	{
		deviceIcon = s;
	}

	public void setDeviceLock(String s)
	{
		deviceLock = s;
	}

	public void setDeviceMac(String s)
	{
		deviceMac = s;
	}

	public void setDeviceName(String s)
	{
		deviceName = s;
	}

	public void setDevicePassword(String s)
	{
		devicePassword = s;
	}

	public void setDeviceType(String s)
	{
		deviceType = s;
	}

	public void setGetTime(long l)
	{
		getTime = l;
	}

	public void setLocal(boolean flag)
	{
		isLocal = flag;
	}

	public void setLocalIp(String s)
	{
		localIp = s;
	}

	public void setMagic(String s)
	{
		magic = s;
	}

	public void setOnline(boolean flag)
	{
		online = flag;
	}

	public void setServerIp(String s)
	{
		ServerIp = s;
	}

	public void setServerPort(int i)
	{
		ServerPort = i;
	}

	public void setSwitchStatus(int i)
	{
		switchStatus = i;
	}

	public void setTimer(String s)
	{
		timer = s;
	}
}
