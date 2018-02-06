package com.liberate.automation.testcases;

import com.liberate.automation.common.CommonData;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.AddMore;
import com.liberate.automation.pom.CPExistingCustomer;
import com.liberate.automation.pom.CPNewCustomer;
import com.liberate.automation.pom.CRServiceOrder;
import com.liberate.automation.pom.SalesSignOff;

public class ServiceProvisioningTC {
	static TestActions action = CommonLogin.action;

	public static void newCustomerPEL() {
		String TestCase = "ServiceProvisioningTC_newCustomerPEL";

		CPNewCustomer cp = new CPNewCustomer(action);
		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);

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
		cp.verifyCreatedAccount();

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

		sso.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
	}

	public static void existingCustomerPEL() {
		String TestCase = "ServiceProvisioningTC_existingCustomerPEL";

		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);

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

		sso.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
	}

	public static void existingCustomerPCLPostpaid() {
		String TestCase = "ServiceProvisioningTC_existingCustomerPCLPostpaid";

		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);

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

		sso.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
	}

	public static void newCustomerPCLPostpaid() {
		String TestCase = "ServiceProvisioningTC_newCustomerPCLPostpaid";

		CPNewCustomer cp = new CPNewCustomer(action);
		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);

		cp.navigate();
		action.getScreenShot(TestCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.MobilepostpaidResidential,
				CommonData.CustomerType.Residential, "PCL", "LIME_POST");
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
		cp.verifyCreatedAccount();

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

		sso.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
	}

	public static void newCustomerPCLCreditLimit() {
		String TestCase = "ServiceProvisioningTC_newCustomerPCLCreditLimit";

		CPNewCustomer cp = new CPNewCustomer(action);
		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);

		cp.navigate();
		action.getScreenShot(TestCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.MobilepostpaidResidential,
				CommonData.CustomerType.Residential, "PCL", "LIME_POST");
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
		cp.verifyCreatedAccount();

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

		sso.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
	}

	public static void existingCustomerPDL() {
		String TestCase = "ServiceProvisioningTC_existingCustomerPDL";

		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);

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

		sso.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
	}

	public static void existingCustomerPTV() {
		String TestCase = "ServiceProvisioningTC_existingCustomerPTV";

		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);

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

		sso.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
	}

	public static void existingCustomerIPTV() {
		String TestCase = "ServiceProvisioningTC_existingCustomerIPTV";

		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);

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

		sso.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
	}

	public static void existingCustomerARN() {
		String TestCase = "ServiceProvisioningTC_existingCustomerARN";

		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);

		ce.navigate();
		action.getScreenShot(TestCase);
		ce.searchWithAccount("260002270000");
		action.getScreenShot(TestCase);
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(TestCase);
		ce.selectNonPackage("ARN");
		action.getScreenShot(TestCase);

		ce.processServiceNoScreen("510370");
		action.getScreenShot(TestCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(TestCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(TestCase);
		ce.provideContractDetails();
		action.getScreenShot(TestCase);

		sso.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
	}

	public static void newCustomerPELandPDL() {
		String TestCase = "ServiceProvisioningTC_newCustomerPELandPDL";

		CPNewCustomer cp = new CPNewCustomer(action);
		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);

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
		cp.verifyCreatedAccount();

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

		sso.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
	}

	public static void addMorePELandPDL() {
		String TestCase = "ServiceProvisioningTC_addMorePELandPDL";

		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);
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

		sso.verifySalesSignOff();
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

		sso.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
	}

	public static void addMorePELandPCL() {
		String TestCase = "ServiceProvisioningTC_addMorePELandPCL";

		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);
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

		sso.verifySalesSignOff();
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

		sso.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sso.signOff();
		action.getScreenShot(TestCase);

		cso.getSONumber();
		action.getScreenShot(TestCase);
		cso.getSOCommand();
		action.getScreenShot(TestCase);
	}
}
