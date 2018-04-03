package com.liberate.automation.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.common.CommonData;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.pom.AddMore;
import com.liberate.automation.pom.ExistingCustomer;
import com.liberate.automation.pom.NewCustomer;
import com.liberate.automation.pom.CustomerServiceOrder;
import com.liberate.automation.pom.SalesSignOff;

/***
 * Class with Service Provisioning Test Cases
 * @author Nikhil
 *
 */
public class ServiceProvisioningTC {
	static TestActions action = CommonLogin.action;

	static String arnServiceNumber = "";

	@BeforeClass
	public static void loadData() {
		arnServiceNumber = TestData.arnServiceNumber;
	}

	@Test
	public static void newCustomerPEL() {
		String TestCase = "ServiceProvisioningTC_newCustomerPEL";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		cp.navigate();
		action.getScreenShot(TestCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,
				"PEL", "ETFT");
		action.getScreenShot(TestCase);

		cp.fillResidentialCustomerDetails();
		action.getScreenShot(TestCase);
		cp.fillStandardAddress();
		action.getScreenShot(TestCase);
		cp.fillCustomerClassification();
		action.getScreenShot(TestCase);
		cp.fillBillingDetails();
		action.getScreenShot(TestCase);
		cp.fillCustomerID();
		action.getScreenShot(TestCase);
		cp.fillContactDetails();
		action.getScreenShot(TestCase);
		assertTrue(cp.verifyCreatedAccount());

		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(TestCase);
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot(TestCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(TestCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);
		ce.skipADSL();
		action.getScreenShot(TestCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void existingCustomerPEL() {
		String TestCase = "ServiceProvisioningTC_existingCustomerPEL";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(TestCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(TestCase);
		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(TestCase);
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot(TestCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(TestCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);
		ce.skipADSL();
		action.getScreenShot(TestCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void existingCustomerPCLPostpaid() {
		String TestCase = "ServiceProvisioningTC_existingCustomerPCLPostpaid";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(TestCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(TestCase);
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(TestCase);
		ce.selectServicePackage("PCL", "LIME_POST");
		// ce.selectServicePackage("PCL", "SOW-");
		action.getScreenShot(TestCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(TestCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void newCustomerPCLPostpaid() {
		String TestCase = "ServiceProvisioningTC_newCustomerPCLPostpaid";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		cp.navigate();
		action.getScreenShot(TestCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,
				"PCL", "LIME_POST");
		action.getScreenShot(TestCase);

		cp.fillResidentialCustomerDetails();
		action.getScreenShot(TestCase);
		cp.fillStandardAddress();
		action.getScreenShot(TestCase);
		cp.fillCustomerClassification();
		action.getScreenShot(TestCase);
		cp.fillBillingDetails();
		action.getScreenShot(TestCase);
		cp.fillCustomerID();
		action.getScreenShot(TestCase);
		cp.fillContactDetails();
		action.getScreenShot(TestCase);
		assertTrue(cp.verifyCreatedAccount());

		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(TestCase);
		ce.selectServicePackage("PCL", "LIME_POST");
		action.getScreenShot(TestCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(TestCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void newCustomerPCLCreditLimit() {
		String TestCase = "ServiceProvisioningTC_newCustomerPCLCreditLimit";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		cp.navigate();
		action.getScreenShot(TestCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,
				"PCL", "LIME_POST");
		action.getScreenShot(TestCase);

		cp.fillResidentialCustomerDetails();
		action.getScreenShot(TestCase);
		cp.fillStandardAddress();
		action.getScreenShot(TestCase);
		cp.fillCustomerClassification();
		action.getScreenShot(TestCase);
		cp.fillBillingDetails();
		action.getScreenShot(TestCase);
		cp.fillCustomerID();
		action.getScreenShot(TestCase);
		cp.fillContactDetails();
		action.getScreenShot(TestCase);
		assertTrue(cp.verifyCreatedAccount());

		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(TestCase);
		ce.selectServicePackage("PCL", "LIME_POST");
		action.getScreenShot(TestCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void existingCustomerPDL() {
		String TestCase = "ServiceProvisioningTC_existingCustomerPDL";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(TestCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(TestCase);
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(TestCase);
		ce.selectServicePackage("PDL", "ADSL_PACK");
		action.getScreenShot(TestCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void existingCustomerPTV() {
		String TestCase = "ServiceProvisioningTC_existingCustomerPTV";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(TestCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(TestCase);
		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(TestCase);
		ce.selectServicePackage("PTV - ", "CableTV");
		action.getScreenShot(TestCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void existingCustomerIPTV() {
		String TestCase = "ServiceProvisioningTC_existingCustomerIPTV";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(TestCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(TestCase);
		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(TestCase);
		ce.selectServicePackage("PTI - ", "IPTVBasic");
		action.getScreenShot(TestCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(enabled = false)
	public static void existingCustomerARN() {
		String TestCase = "ServiceProvisioningTC_existingCustomerARN";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(TestCase);
		ce.searchWithAccount("260002270000");
		action.getScreenShot(TestCase);
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(TestCase);
		ce.selectNonPackage("ARN");
		action.getScreenShot(TestCase);

		ce.processServiceNoScreen(arnServiceNumber);
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void newCustomerPELandPDL() {
		String TestCase = "ServiceProvisioningTC_newCustomerPELandPDL";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		cp.navigate();
		action.getScreenShot(TestCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,
				"PEL", "ETFT");
		action.getScreenShot(TestCase);

		cp.fillResidentialCustomerDetails();
		action.getScreenShot(TestCase);
		cp.fillStandardAddress();
		action.getScreenShot(TestCase);
		cp.fillCustomerClassification();
		action.getScreenShot(TestCase);
		cp.fillBillingDetails();
		action.getScreenShot(TestCase);
		cp.fillCustomerID();
		action.getScreenShot(TestCase);
		cp.fillContactDetails();
		action.getScreenShot(TestCase);
		assertTrue(cp.verifyCreatedAccount());
		action.getScreenShot(TestCase);

		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(TestCase);
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot(TestCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(TestCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);
		ce.provideADSL();
		action.getScreenShot(TestCase);

		// PDL Part
		ce.selectServicePackage("PDL", "ADSL_PACK");
		action.getScreenShot(TestCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void addMorePELandPDL() {
		String TestCase = "ServiceProvisioningTC_addMorePELandPDL";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);
		AddMore addmore = new AddMore(action);

		ce.navigate();
		action.getScreenShot(TestCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(TestCase);
		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(TestCase);
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot(TestCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(TestCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);
		ce.skipADSL();
		action.getScreenShot(TestCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(TestCase);
		sso.addMore();
		action.getScreenShot(TestCase);

		addmore.addADSL();
		action.getScreenShot(TestCase);

		// PDL Part
		ce.selectServicePackage("PDL", "ADSL_PACK");
		action.getScreenShot(TestCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void addMorePELandPCL() {
		String TestCase = "ServiceProvisioningTC_addMorePELandPCL";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);
		AddMore addmore = new AddMore(action);

		ce.navigate();
		action.getScreenShot(TestCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(TestCase);
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(TestCase);
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot(TestCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(TestCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);
		ce.skipADSL();
		action.getScreenShot(TestCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(TestCase);
		sso.addMore();
		action.getScreenShot(TestCase);

		addmore.addServicePackage();
		action.getScreenShot(TestCase);

		action.getScreenShot(TestCase);
		ce.selectServicePackage("PCL", "LIME_POST");
		// ce.selectServicePackage("PCL", "SOW-");
		action.getScreenShot(TestCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(TestCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}
}
