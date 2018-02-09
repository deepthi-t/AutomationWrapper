package com.liberate.automation.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.pom.CRAccountPricingPlans;
import com.liberate.automation.pom.CRAdjustments;
import com.liberate.automation.pom.CRBills;
import com.liberate.automation.pom.CRCustomerDetails;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CRDashBoard;
import com.liberate.automation.pom.CRServiceCharges;

public class CustomerEnquiryTC {
	static TestActions action = CommonLogin.action;

	public static String accountNumber = "";
	public static String surName = "";
	public static String pricingPlanAccount = "";
	
	@BeforeClass
	public static void loadData() {
		accountNumber = TestData.accountNumber;
		surName = TestData.surName;
		pricingPlanAccount = TestData.pricingPlanAccount;
	}

	@Test(priority = 1)
	public static void verifyCustomerEnquiry() {
		String TestCase = "CustomerEnquiryTC_verifyCustomerEnquiry";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRDashBoard cd = new CRDashBoard(action);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchByAccountNumber(accountNumber);
		action.getScreenShot(TestCase);
		cd.navigate();
		action.getScreenShot(TestCase);
		cd.verifyDashBoard(accountNumber);
		action.getScreenShot(TestCase);
	}

	@Test
	public static void customerEnquiryWithID() {
		String TestCase = "CustomerEnquiryTC_customerEnquiryWithID";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRDashBoard cd = new CRDashBoard(action);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchByID("NI", "FN9ONJ2S3RPN ");
		action.getScreenShot(TestCase);
		cd.navigate();
		action.getScreenShot(TestCase);
		cd.verifyDashBoard("");
		action.getScreenShot(TestCase);
	}

	@Test
	public static void customerEnquiryWithSurname() {
		String TestCase = "CustomerEnquiryTC_customerEnquiryWithSurname";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRDashBoard cd = new CRDashBoard(action);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchBySurname(surName);
		action.getScreenShot(TestCase);
		cd.navigate();
		action.getScreenShot(TestCase);
		cd.verifyDashBoard("");
		action.getScreenShot(TestCase);
	}

	@Test(priority = 2)
	public static void amendAccountDetails() {
		String TestCase = "CustomerEnquiryTC_amendAccountDetails";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRDashBoard cd = new CRDashBoard(action);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchByAccountNumber(accountNumber);
		action.getScreenShot(TestCase);
		cd.navigate();
		action.getScreenShot(TestCase);
		cd.verifyDashBoard(accountNumber);
		action.getScreenShot(TestCase);

		cd.amendAccount();
		action.getScreenShot(TestCase);
		cd.verifyDashBoard(accountNumber);
		action.getScreenShot(TestCase);
	}

	@Test(priority = 3)
	public static void amendDayOfBilling() {
		String TestCase = "CustomerEnquiryTC_amendDayOfBilling";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRCustomerDetails cu = new CRCustomerDetails(action);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchByAccountNumber("260002330000");
		action.getScreenShot(TestCase);

		cu.navigate();
		action.getScreenShot(TestCase);
		cu.validateGeneralDetails();
		action.getScreenShot(TestCase);
		cu.amendDayOfBilling();
		action.getScreenShot(TestCase);
		cu.validatedayOfBilling();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void raiseAdjustment() {
		String TestCase = "CustomerEnquiryTC_raiseAdjustment";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRAdjustments ad = new CRAdjustments(action);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchByAccountNumber(accountNumber);
		action.getScreenShot(TestCase);

		ad.navigate();
		action.getScreenShot(TestCase);
		ad.raiseAjustment();
		action.getScreenShot(TestCase);
		ad.verifyRaiseAdjustment();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void verifyAdjustment() {
		String TestCase = "CustomerEnquiryTC_verifyAdjustment";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRAdjustments ad = new CRAdjustments(action);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchByAccountNumber(accountNumber);
		action.getScreenShot(TestCase);

		ad.navigate();
		action.getScreenShot(TestCase);
		ad.verifyAdjustmenst();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void addServiceCharge() {
		String TestCase = "CustomerEnquiryTC_addServiceCharge";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRServiceCharges ad = new CRServiceCharges(action);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchByAccountNumber(accountNumber);
		action.getScreenShot(TestCase);

		ad.navigate();
		action.getScreenShot(TestCase);
		ad.addServiceCharge();
		action.getScreenShot(TestCase);
		ad.verifyRaisedServiceCharge();
		action.getScreenShot(TestCase);

	}

	@Test
	public static void verifySericeChargeServiceNumber() {
		String TestCase = "CustomerEnquiryTC_verifySericeChargeServiceNumber";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRServiceCharges ad = new CRServiceCharges(action);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchByAccountNumber(accountNumber);
		action.getScreenShot(TestCase);

		ad.navigate();
		action.getScreenShot(TestCase);
		ad.searchWithServiceNumber();
		action.getScreenShot(TestCase);
		ad.verifyServiceCharge();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void verifySericeChargeAccount() {
		String TestCase = "CustomerEnquiryTC_verifySericeChargeAccount";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRServiceCharges ad = new CRServiceCharges(action);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchByAccountNumber(accountNumber);
		action.getScreenShot(TestCase);

		ad.navigate();
		action.getScreenShot(TestCase);
		ad.verifyServiceCharge();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void verifyBills() {
		// Should be executed in S10
		String TestCase = "CustomerEnquiryTC_verifyBills";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRBills cb = new CRBills(action);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchByAccountNumber("150303960000");
		action.getScreenShot(TestCase);

		cb.navigate();
		action.getScreenShot(TestCase);
		cb.verifyBill();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void addNominatedNumPricingPlan() {
		String TestCase = "CustomerEnquiryTC_addNominatedNumPricingPlan";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRAccountPricingPlans cp = new CRAccountPricingPlans(action);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchByAccountNumber(pricingPlanAccount);
		action.getScreenShot(TestCase);

		cp.navigate();
		action.getScreenShot(TestCase);
		cp.searchPricingPlan("AC+NN");
		action.getScreenShot(TestCase);
		cp.addPricingPlan();
		action.getScreenShot(TestCase);
		cp.validatePricingPlan();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void addCUGPricingPlan() {
		String TestCase = "CustomerEnquiryTC_addCUGPricingPlan";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRAccountPricingPlans cp = new CRAccountPricingPlans(action);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchByAccountNumber(pricingPlanAccount);
		action.getScreenShot(TestCase);

		cp.navigate();
		action.getScreenShot(TestCase);
		cp.searchPricingPlan("CUG");
		action.getScreenShot(TestCase);
		cp.addPricingPlan();
		action.getScreenShot(TestCase);
		cp.validatePricingPlan();
		action.getScreenShot(TestCase);
	}
}
