package com.liberate.automation.main;

import com.liberate.automation.testcases.BadChequeProcessing;
import com.liberate.automation.testcases.CommonLogin;

public class Main {

	public static void main(String[] args) {
//		while (true) {
			CommonLogin.navigateToURL();
			BadChequeProcessing.badCheckProcessing();
//			CommonLogin.endTesting();
//		}
	}
}