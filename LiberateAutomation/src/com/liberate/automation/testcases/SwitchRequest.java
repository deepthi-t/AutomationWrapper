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
		msr.select_MonitorNewSwitchRequests();
		msr.MonitorNewSwitchRequests_Search("99999", "23:30");

		return true;
	}

	public static boolean FailureQueries(TestActions action) {
		ManageSwitchRequest msr = new ManageSwitchRequest(action);
		Login login = new Login(action);

		login.login("libadmin", "Ic3cr34m!");
		msr.navigate();
		msr.select_FailureQueries();
		msr.FailureQueries("FLOW-FLOW TV Gateway Interface", "CAY-Cayman Islands Region", "FLOW-FLOW", "",
				"31/05/2015 03:15", "31/05/2017 03:15");

		return true;
	}
	
	public static boolean queryByCustomerDetails(TestActions action)
	{
		ManageSwitchRequest msr = new ManageSwitchRequest(action);
		Login login = new Login(action);
		
		login.login("libadmin", "Ic3cr34m!");
		msr.navigate();
		msr.select_QuerybyAcctServiceOrderServiceCommand();
		msr.QueryByCustomerDetails("260002430000", "", "", "");
		
		return true;
	}
	
	public static boolean generatQueryOnSwitchRequest(TestActions action)
	{
		ManageSwitchRequest msr = new ManageSwitchRequest(action);
		Login login = new Login(action);
		
		login.login("libadmin", "Ic3cr34m!");
		msr.navigate();
		msr.select_GeneralQueryOnNewRequests();
		msr.GeneralQUery("C-Complete", "FLOW-FLOW TV Gateway Interface", "CAY-Cayman Islands Region", "FLOW-FLOW", "",
				"31/05/2015 03:15", "31/05/2017 03:15");
		
		return true;
	}
}
