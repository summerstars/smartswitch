// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 

package com.smartswitch.db.dao;

import com.broadlink.switchproduct.db.data.ManageDevice;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;

// Referenced classes of package com.broadlink.switchproduct.db.dao:
//			DatabaseHelper

public class ManageDeviceDao extends BaseDaoImpl
{

	public ManageDeviceDao(DatabaseHelper databasehelper)
		throws SQLException
	{
		super(databasehelper.getConnectionSource(), com/broadlink/switchproduct/db/data/ManageDevice);
	}

	public ManageDeviceDao(ConnectionSource connectionsource, Class class1)
		throws SQLException
	{
		super(connectionsource, class1);
	}

	public ManageDevice getDeviceByMac(String s)
		throws SQLException
	{
		ManageDevice managedevice = new ManageDevice();
		QueryBuilder querybuilder = queryBuilder();
		querybuilder.where().eq("deviceMac", s);
		List list = query(querybuilder.prepare());
		if (!list.isEmpty())
			managedevice = (ManageDevice)list.get(0);
		return managedevice;
	}
}
