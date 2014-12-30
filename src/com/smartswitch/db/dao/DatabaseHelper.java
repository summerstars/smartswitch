// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 

package com.smartswitch.db.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper
{

	public DatabaseHelper(Context context)
	{
		super(context, "switch.db", null, 4);
	}

	public void onCreate(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource)
	{
		try
		{
			TableUtils.createTableIfNotExists(connectionsource, com/broadlink/switchproduct/db/data/ManageDevice);
			return;
		}
		catch (SQLException sqlexception)
		{
			sqlexception.printStackTrace();
		}
	}

	public void onUpgrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int i, int j)
	{
		try
		{
			TableUtils.dropTable(connectionsource, com/broadlink/switchproduct/db/data/ManageDevice, true);
			onCreate(sqlitedatabase, connectionsource);
			Log.e(com/broadlink/switchproduct/db/dao/DatabaseHelper.getName(), "更新数据库成功");
			return;
		}
		catch (SQLException sqlexception)
		{
			Log.e(com/broadlink/switchproduct/db/dao/DatabaseHelper.getName(), "更新数据库失败", sqlexception);
		}
	}
}
