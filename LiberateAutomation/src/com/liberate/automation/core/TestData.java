package com.liberate.automation.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TestData {

	public static String queryNumber = "";
	public static String faultNumber = "";
	public static String userName = "";
	public static String passWord = "";
	public static String autURL = "";
	public static String creditControlServiceNumber = "";
	public static String employeeID = "";
	public static String switchRequestTime = "";
	public static String switchRequestAccountNumber = "";
	public static String badChequePaymentNumber = "";
	public static String networkDepartment = "";
	public static String generalDepartment = "";
	public static String accountDepartment = "";

	static String FileName = "TestData.properties";

	static Properties properties = new Properties();

	@SuppressWarnings("unused")
	private static void saveData(String dataName, String data) {
		properties.setProperty("queryNumber", queryNumber);
		properties.setProperty("faultNumber", faultNumber);
		properties.setProperty("userName", userName);
		properties.setProperty("passWord", passWord);
		properties.setProperty("autURL", autURL);
		properties.setProperty("creditControlServiceNumber", creditControlServiceNumber);
		properties.setProperty("employeeID", employeeID);
		properties.setProperty("switchRequestTime", switchRequestTime);
		properties.setProperty("switchRequestAccountNumber", switchRequestAccountNumber);
		properties.setProperty("badChequePaymentNumber", badChequePaymentNumber);
		properties.setProperty("networkDepartment", networkDepartment);
		properties.setProperty("generalDepartment", generalDepartment);
		properties.setProperty("accountDepartment", accountDepartment);

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

	private static String getData(String dataName) {
		try {
			properties.load(new FileInputStream(FileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String data = properties.getProperty(dataName);

		System.out.println(data);

		return data;
	}

	public static void loadTestData() {
		queryNumber = getData("queryNumber");
		faultNumber = getData("faultNumber");
		userName = getData("userName");
		passWord = getData("passWord");
		autURL = getData("autURL");
		creditControlServiceNumber = getData("creditControlServiceNumber");
		employeeID = getData("employeeID");
		switchRequestTime = getData("switchRequestTime");
		switchRequestAccountNumber = getData("switchRequestAccountNumber");
		badChequePaymentNumber = getData("badChequePaymentNumber");
		networkDepartment = getData("networkDepartment");
		generalDepartment = getData("generalDepartment");
		generalDepartment = getData("generalDepartment");
	}
}
