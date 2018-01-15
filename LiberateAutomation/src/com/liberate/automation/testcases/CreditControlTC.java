package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CreditControlService;

public class CreditControlTC {
	static TestActions action = CommonLogin.action;

	@Test
	public void serviceBAR()
	{
		CreditControlService msr = new CreditControlService(action);

		msr.navigate();
		msr.searchWithServiceNumber("9177243");
		msr.serviceBAR();
		msr.verifyServiceStatus();
	}
	
	@Test
	public void serviceTOS()
	{
		CreditControlService msr = new CreditControlService(action);

		msr.navigate();
		msr.searchWithServiceNumber("9177243");
		msr.serviceTOS();
		msr.verifyServiceStatus();
	}
	
	@Test
	public void serviceROS()
	{
		CreditControlService msr = new CreditControlService(action);

		msr.navigate();
		msr.searchWithServiceNumber("9177243");
		msr.serviceROS();
		msr.verifyServiceStatus();
	}
}
