package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CRAdjustments;
import com.liberate.automation.pom.CRCustomerDetails;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CRDashBoard;

public class CustomerEnquiryTC {
	static TestActions action = CommonLogin.action;

	@Test(priority = 1)
	public void verifyCustomerEnquiry() {
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRDashBoard cd = new CRDashBoard(action);

		cr.navigate();
		action.getScreenShot("verifyCustomerEnquiry");
		cr.searchByAccountNumber("260002260000");
		action.getScreenShot("verifyCustomerEnquiry");
		cd.navigate();
		action.getScreenShot("verifyCustomerEnquiry");
		cd.verifyDashBoard("260002260000");
		action.getScreenShot("verifyCustomerEnquiry");
	}

	
	@Test(priority = 2)
	public void amendAccountDetails() {
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRDashBoard cd = new CRDashBoard(action);

		cr.navigate();
		action.getScreenShot("amendAccountDetails");
		cr.searchByAccountNumber("260002270000");
		action.getScreenShot("amendAccountDetails");
		cd.navigate();
		action.getScreenShot("amendAccountDetails");
		cd.verifyDashBoard("260002270000");
		action.getScreenShot("amendAccountDetails");

		cd.amendAccount();
		action.getScreenShot("amendAccountDetails");
		cd.verifyDashBoard("260002270000");
		action.getScreenShot("amendAccountDetails");
	}

	@Test(priority = 3)
	public void amendDayOfBilling() {
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRCustomerDetails cu = new CRCustomerDetails(action);

		cr.navigate();
		action.getScreenShot("amendDayOfBilling");
		cr.searchByAccountNumber("260002320000");
		action.getScreenShot("amendDayOfBilling");

		cu.navigate();
		action.getScreenShot("amendDayOfBilling");
		cu.validateGeneralDetails();
		action.getScreenShot("amendDayOfBilling");
		cu.amendDayOfBilling();
		action.getScreenShot("amendDayOfBilling");
		cu.validatedayOfBilling();
		action.getScreenShot("amendDayOfBilling");
	}

	@Test
	public void raiseAdjustment() {
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRAdjustments ad = new CRAdjustments(action);
		
		cr.navigate();
		action.getScreenShot("addAdjustment");
		cr.searchByAccountNumber("260002260000");
		action.getScreenShot("addAdjustment");
		
		ad.navigate();
		action.getScreenShot("addAdjustment");
		ad.raiseAjustment();
		action.getScreenShot("addAdjustment");
		ad.verifyRaiseAdjustment();
		action.getScreenShot("addAdjustment");
	}

	@Test
	public void verifyAdjustment() {
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRAdjustments ad = new CRAdjustments(action);
		
		cr.navigate();
		action.getScreenShot("verifyAdjustment");
		cr.searchByAccountNumber("260002260000");
		action.getScreenShot("verifyAdjustment");
		
		ad.navigate();
		action.getScreenShot("verifyAdjustment");
		ad.verifyAdjustmenst();
		action.getScreenShot("verifyAdjustment");
	}
}
