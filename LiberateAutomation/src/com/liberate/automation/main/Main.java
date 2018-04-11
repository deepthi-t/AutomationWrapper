package com.liberate.automation.main;

import com.liberate.automation.testcases.AlterServiceTC;
import com.liberate.automation.testcases.CommonLogin;

public class Main {

	public static void main(String[] args) {		
		CommonLogin.login();
		AlterServiceTC.loadData();
		AlterServiceTC.alterSIMCard();
	}
	
	public void test()
	{
		
	}
}