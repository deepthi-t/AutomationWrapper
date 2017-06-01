package com.liberate.automation.main;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.testcases.SwitchRequest;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestActions action = new TestActions();
		action.gotoURL("http://172.21.73.80:8081/liberate-LONI01-S10/");
		
		SwitchRequest.queryByCustomerDetails(action);
	}

}
