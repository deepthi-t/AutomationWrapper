package com.liberate.automation.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TestData {
	public static String QueryNumber = "";
	
	public static String FaultNumber = "";
	
	static String FileName = "TestData.properties";
	
	static Properties properties = new Properties();
			
	@SuppressWarnings("unused")
	private static void saveData(String dataName, String data) {
		properties.setProperty (dataName, data);
		
		try {
			properties.store(new FileOutputStream(FileName), null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getData(String dataName) {
		try {
			properties.load(new FileInputStream(FileName));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		String data = properties.getProperty(dataName);
		
		System.out.println(data);
		
		return data;
	}
}
