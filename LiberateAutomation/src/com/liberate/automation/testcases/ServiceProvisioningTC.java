package com.liberate.automation.testcases;

import com.liberate.automation.common.CommonData;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CPExistingCustomer;
import com.liberate.automation.pom.CPNewCustomer;
import com.liberate.automation.pom.CRServiceOrder;
import com.liberate.automation.pom.SalesSignOff;

public class ServiceProvisioningTC {
	static TestActions action = CommonLogin.action;

	public void newCustomerPEL() {
		CPNewCustomer cp = new CPNewCustomer(action);
		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);

		cp.navigate();
		action.getScreenShot("newCustomerPEL");
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,
				"PEL", "ETFT");
		action.getScreenShot("newCustomerPEL");

		cp.fillResidentialCustomerDetails();
		action.getScreenShot("newCustomerPEL");
		cp.fillStandardAddress();
		action.getScreenShot("newCustomerPEL");
		cp.fillCustomerClassification();
		action.getScreenShot("newCustomerPEL");
		cp.fillBillingDetails();
		action.getScreenShot("newCustomerPEL");
		cp.fillCustomerID();
		action.getScreenShot("newCustomerPEL");
		cp.fillContactDetails();
		action.getScreenShot("newCustomerPEL");
		cp.verifyCreatedAccount();

		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot("newCustomerPEL");
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot("newCustomerPEL");
		ce.processPricingPlanScreen();
		action.getScreenShot("newCustomerPEL");
		ce.processServiceProductsScreen();
		action.getScreenShot("newCustomerPEL");
		ce.processProductFieldsScreen();
		action.getScreenShot("newCustomerPEL");
		ce.processISPFieldsScreen();
		action.getScreenShot("newCustomerPEL");
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot("newCustomerPEL");
		ce.provideContractDetails();
		action.getScreenShot("newCustomerPEL");
		ce.skipADSL();
		action.getScreenShot("newCustomerPEL");

		sso.verifySalesSignOff();
		action.getScreenShot("newCustomerPEL");
		sso.signOff();
		action.getScreenShot("newCustomerPEL");

		cso.getSONumber();
		action.getScreenShot("newCustomerPEL");
		cso.getSOCommand();
		action.getScreenShot("newCustomerPEL");
	}

	public void existingCustomerPEL() {
		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);

		ce.navigate();
		action.getScreenShot("existingCustomerPEL");
		ce.searchWithAccount("280000710000");
		action.getScreenShot("existingCustomerPEL");
		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot("existingCustomerPEL");
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot("existingCustomerPEL");
		ce.processPricingPlanScreen();
		action.getScreenShot("existingCustomerPEL");
		ce.processServiceProductsScreen();
		action.getScreenShot("existingCustomerPEL");
		ce.processProductFieldsScreen();
		action.getScreenShot("existingCustomerPEL");
		ce.processISPFieldsScreen();
		action.getScreenShot("existingCustomerPEL");
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot("existingCustomerPEL");
		ce.provideContractDetails();
		action.getScreenShot("existingCustomerPEL");
		ce.skipADSL();
		action.getScreenShot("existingCustomerPEL");

		sso.verifySalesSignOff();
		action.getScreenShot("existingCustomerPEL");
		sso.signOff();
		action.getScreenShot("existingCustomerPEL");

		cso.getSONumber();
		action.getScreenShot("existingCustomerPEL");
		cso.getSOCommand();
		action.getScreenShot("existingCustomerPEL");
	}
}
