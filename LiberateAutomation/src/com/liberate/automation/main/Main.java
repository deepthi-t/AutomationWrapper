package com.liberate.automation.main;

import com.liberate.automation.testcases.AlterProductTC;
import com.liberate.automation.testcases.CommonLogin;

public class Main {

	public static void main(String[] args) {		
		CommonLogin.login();
		AlterProductTC.loadData();
		
		AlterProductTC.alterProducts();
	}
	
	public void test()
	{
		
	}
}