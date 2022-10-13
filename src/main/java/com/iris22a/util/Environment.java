package com.iris22a.util;

import java.io.FileNotFoundException;

public class Environment {

	private static String filePath = "/src/main/resoures/Environment.properties";

	public static String URL;
	public static String appUser1;

	public static String BROWSER;

	static{
		PropUtil prop = new PropUtil();
		String baseDir = System.getProperty("user.dir");
		try {
			URL = prop.getValue(baseDir + filePath, "app_url");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			appUser1 = prop.getValue(baseDir + filePath, "appUser1");
			BROWSER=prop.getValue(baseDir + filePath, "browser_name");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
