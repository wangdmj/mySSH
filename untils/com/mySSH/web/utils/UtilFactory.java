package com.mySSH.web.utils;

public class UtilFactory {
	public static <T> T getInstance(Class<T> t)throws Exception{
		return (T)t.newInstance();
	}
}
