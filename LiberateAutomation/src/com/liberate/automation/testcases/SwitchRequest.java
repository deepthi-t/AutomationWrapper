package com.liberate.automation.testcases;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.Login;
import com.liberate.automation.pom.ManageSwitchRequest;

public class SwitchRequest {

	public static boolean MonitorNewSwitchRequest(TestActions action) {

		ManageSwitchRequest msr = new ManageSwitchRequest(action);
		Login login = new Login(action);

		login.login("libadmin", "Ic3cr34m!");
		msr.navigate();
		action.getScreenShot("MonitorNewSwitchRequest");
		msr.select_MonitorNewSwitchRequests();
		action.getScreenShot("MonitorNewSwitchRequest");
		msr.MonitorNewSwitchRequests_Search("99999", "23:30");
		action.getScreenShot("MonitorNewSwitchRequest");
		msr.verifyResults();
		action.getScreenShot("MonitorNewSwitchRequest");

		return true;
	}

	public static boolean FailureQueries(TestActions action) {
		ManageSwitchRequest msr = new ManageSwitchRequest(action);
		Login login = new Login(action);

		login.login("libadmin", "Ic3cr34m!");
		action.getScreenShot("FailureQueries");
		msr.navigate();
		action.getScreenShot("FailureQueries");
		msr.select_FailureQueries();
		action.getScreenShot("FailureQueries");
		msr.FailureQueries("FLOW-FLOW TV Gateway Interface", "CAY-Cayman Islands Region", "FLOW-FLOW", "",
				"31/05/2015 03:15", "31/05/2017 03:15");
		action.getScreenShot("FailureQueries");
		msr.verifyResults();
		action.getScreenShot("MonitorNewSwitchRequest");

		return true;
	}
	
	public static boolean queryByCustomerDetails_AccountNumber(TestActions action)
	{
		ManageSwitchRequest msr = new ManageSwitchRequest(action);
		Login login = new Login(action);
		
		login.login("libadmin", "Ic3cr34m!");
		action.getScreenShot("queryByCustomerDetails_AccountNumber");
		msr.navigate();
		action.getScreenShot("queryByCustomerDetails_AccountNumber");
		msr.select_QuerybyAcctServiceOrderServiceCommand();
		action.getScreenShot("queryByCustomerDetails_AccountNumber");
		msr.QueryByCustomerDetails("260002430000", "", "", "");
		action.getScreenShot("queryByCustomerDetails_AccountNumber");
		msr.verifyResults();
		action.getScreenShot("queryByCustomerDetails_AccountNumber");

		return true;
	}
	
	public static boolean generatQueryOnSwitchRequest(TestActions action)
	{
		ManageSwitchRequest msr = new ManageSwitchRequest(action);
		Login login = new Login(action);
		
		login.login("libadmin", "Ic3cr34m!");
		action.getScreenShot("MonitorNewSwitchRequest");
		msr.navigate();
		action.getScreenShot("MonitorNewSwitchRequest");
		msr.select_GeneralQueryOnNewRequests();
		action.getScreenShot("MonitorNewSwitchRequest");
		msr.GeneralQUery("C-Complete", "FLOW-FLOW TV Gateway Interface", "CAY-Cayman Islands Region", "FLOW-FLOW", "",
				"31/05/2015 03:15", "31/05/2017 03:15");
		action.getScreenShot("MonitorNewSwitchRequest");
		msr.verifyResults();
		action.getScreenShot("MonitorNewSwitchRequest");

		return true;
	}
}
