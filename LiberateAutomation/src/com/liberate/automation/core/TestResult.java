package com.liberate.automation.core;

import org.testng.ITestResult;

public class TestResult {
	static String testStatus;

	public static void processTestResult(String testCase, ITestResult result, TestActions action) {
		ReportGenerator.generateReport(testCase);
		testStatus = result.getStatus() == ITestResult.SUCCESS ? "PASSED" : "FAILED";

		TestActions.log("Test Status : " + testStatus);
		TestActions.log("*****COMPLETED '" + testCase + "' EXECUTION***** \n");
	}
}
