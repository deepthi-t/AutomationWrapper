package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CreditControlService;

public class CreditControlTC {
	static TestActions action = CommonLogin.action;

	@Test
	public void serviceBAR() {
		CreditControlService msr = new CreditControlService(action);

		msr.navigate();
		action.getScreenShot("serviceBAR");
		msr.searchWithServiceNumber("9177243");
		action.getScreenShot("serviceBAR");
		msr.serviceBAR();
		action.getScreenShot("serviceBAR");
		msr.verifyServiceStatus();
		action.getScreenShot("serviceBAR");
	}

	@Test
	public void serviceTOS() {
		CreditControlService msr = new CreditControlService(action);

		msr.navigate();
		action.getScreenShot("serviceTOS");
		msr.searchWithServiceNumber("9177243");
		action.getScreenShot("serviceTOS");
		msr.serviceTOS();
		action.getScreenShot("serviceTOS");
		msr.verifyServiceStatus();
		action.getScreenShot("serviceTOS");
	}

	@Test
	public void serviceROS() {
		CreditControlService msr = new CreditControlService(action);

		msr.navigate();
		action.getScreenShot("serviceROS");
		msr.searchWithServiceNumber("9177243");
		action.getScreenShot("serviceROS");
		msr.serviceROS();
		action.getScreenShot("serviceROS");
		msr.verifyServiceStatus();
		action.getScreenShot("serviceROS");
	}
}
