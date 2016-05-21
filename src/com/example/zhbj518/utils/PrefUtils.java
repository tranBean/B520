package com.example.zhbj518.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefUtils 
{
	public static final String PREF_NAME = "config";
	public static boolean getBoolean(Context ctx,String key,boolean defaultValue)
	{
		SharedPreferences sharedPreferences = ctx.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		return sharedPreferences.getBoolean(key, defaultValue);//false ---> No
	}
	
	public static void setBoolean(Context ctx,String key,boolean value)
	{
		SharedPreferences sharedPreferences = ctx.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		sharedPreferences.edit().putBoolean(key, value).commit();
	}
	
}
