package com.liberate.automation.main;

import com.liberate.automation.testcases.CommonLogin;
import com.liberate.automation.testcases.ComverseTC;
import com.liberate.automation.testcases.CustomerEnquiryTC;
import com.liberate.automation.testcases.QueryManagementTC;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		CommonLogin.login();
		ComverseTC.transferBalance();
		
	}

}

