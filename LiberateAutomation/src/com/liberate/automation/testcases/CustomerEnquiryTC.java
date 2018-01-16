package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CRDashBoard;

public class CustomerEnquiryTC {
	static TestActions action = CommonLogin.action;

	@Test
	public void verifyCustomerEnquiry()
	{
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRDashBoard cd = new CRDashBoard(action);
		
		cr.navigate();
		cr.searchByAccountNumber("260002260000");
		cd.navigate();
		cd.verifyDashBoard("260002260000");
	}
	
	@Test
	public void amendAccountDetails()
	{
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRDashBoard cd = new CRDashBoard(action);
		
		cr.navigate();
		cr.searchByAccountNumber("260002270000");
		cd.navigate();
		cd.verifyDashBoard("260002270000");
		
		cd.amendAccount();
		cd.verifyDashBoard("260002270000");
	}
}
