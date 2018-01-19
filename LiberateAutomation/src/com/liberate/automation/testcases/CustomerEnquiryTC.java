package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CRAdjustments;
import com.liberate.automation.pom.CRBills;
import com.liberate.automation.pom.CRCustomerDetails;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CRDashBoard;
import com.liberate.automation.pom.CRServiceCharges;
import com.liberate.automation.pom.CRServiceOperations;

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

	public void customerEnquiryWithID() {
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRDashBoard cd = new CRDashBoard(action);

		cr.navigate();
		action.getScreenShot("customerEnquiryWithID");
		cr.searchByID("NI", "FN9ONJ2S3RPN ");
		action.getScreenShot("customerEnquiryWithID");
		cd.navigate();
		action.getScreenShot("customerEnquiryWithID");
		cd.verifyDashBoard("");
		action.getScreenShot("customerEnquiryWithID");
	}

	public void customerEnquiryWithSurname() {
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRDashBoard cd = new CRDashBoard(action);

		cr.navigate();
		action.getScreenShot("customerEnquiryWithSurname");
		cr.searchBySurname("bmv8h36pneou");
		action.getScreenShot("customerEnquiryWithSurname");
		cd.navigate();
		action.getScreenShot("customerEnquiryWithSurname");
		cd.verifyDashBoard("");
		action.getScreenShot("customerEnquiryWithSurname");
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

	public void addServiceCharge() {
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRServiceCharges ad = new CRServiceCharges(action);

		cr.navigate();
		action.getScreenShot("addServiceCharge");
		cr.searchByAccountNumber("260002260000");
		action.getScreenShot("addServiceCharge");

		ad.navigate();
		action.getScreenShot("addServiceCharge");
		ad.addServiceCharge();
		action.getScreenShot("addServiceCharge");
		ad.verifyRaisedServiceCharge();
		action.getScreenShot("addServiceCharge");

	}

	public void verifySericeChargeServiceNumber() {
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRServiceCharges ad = new CRServiceCharges(action);

		cr.navigate();
		action.getScreenShot("verifySericeChargeServiceNumber");
		cr.searchByAccountNumber("260002260000");
		action.getScreenShot("verifySericeChargeServiceNumber");

		ad.navigate();
		action.getScreenShot("verifySericeChargeServiceNumber");
		ad.searchWithServiceNumber();
		action.getScreenShot("verifySericeChargeServiceNumber");
		ad.verifyServiceCharge();
		action.getScreenShot("verifySericeChargeServiceNumber");
	}

	public void verifySericeChargeAccount() {
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRServiceCharges ad = new CRServiceCharges(action);

		cr.navigate();
		action.getScreenShot("verifySericeChargeAccount");
		cr.searchByAccountNumber("260002260000");
		action.getScreenShot("verifySericeChargeAccount");

		ad.navigate();
		action.getScreenShot("verifySericeChargeAccount");
		ad.verifyServiceCharge();
		action.getScreenShot("verifySericeChargeAccount");
	}

	public void verifyBills() {
		// Should be executed in S10

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRBills cb = new CRBills(action);

		cr.navigate();
		action.getScreenShot("verifyBills");
		cr.searchByAccountNumber("150303960000");
		action.getScreenShot("verifyBills");

		cb.navigate();
		action.getScreenShot("verifyBills");
		cb.verifyBill();
		action.getScreenShot("verifyBills");
	}

	public void transferService() {
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRServiceOperations sc = new CRServiceOperations(action);

		cr.navigate();
		action.getScreenShot("transferService");
		cr.searchByAccountNumber("260002290000");
		action.getScreenShot("transferService");

		sc.navigate();
		action.getScreenShot("transferService");
		sc.verifyServicesScreen();
		action.getScreenShot("transferService");
		sc.transferService("260002270000");
		action.getScreenShot("transferService");

		sc.verifyTransferService("260002270000");
		action.getScreenShot("transferService");
	}
}
