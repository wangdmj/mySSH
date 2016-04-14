package com.mySSH.web.utils;

public class StringUtils {
	public static boolean isStrEmpty(String str){
		if (str == null || str.trim().isEmpty())
			return true;
		else return false;
	}
}
