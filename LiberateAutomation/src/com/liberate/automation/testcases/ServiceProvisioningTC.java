package com.liberate.automation.testcases;

import com.liberate.automation.common.CommonData;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CPExistingCustomer;
import com.liberate.automation.pom.CPNewCustomer;
import com.liberate.automation.pom.SalesSignOff;

public class ServiceProvisioningTC {
	static TestActions action = CommonLogin.action;

	public void newCustomer() {
		CPNewCustomer cp = new CPNewCustomer(action);

		cp.navigate();
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,
				"PEL", "ETFT");
		
		cp.fillResidentialCustomerDetails();
		cp.fillStandardAddress();
		cp.fillCustomerClassification();
		cp.fillBillingDetails();
		cp.fillCustomerID();
		cp.fillContactDetails();
		cp.verifyCreatedAccount();
	}
	
	public void existingCustomerPEL() {
		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		
		ce.navigate();
		ce.searchWithAccount("280000710000");
		ce.selectDepartmentSite("BGSAL", "BUSG");
		ce.selectServicePackage("PEL", "ETFT");
		ce.processPricingPlanScreen();
		ce.processServiceProductsScreen();
		ce.processProductFieldsScreen();
		ce.processISPFieldsScreen();
		ce.provideServiceDetailsScreen("BOT", "BODD");
		ce.provideContractDetails();
		ce.skipADSL();
		
		sso.verifySalesSignOff();
		sso.signOff();
	}
}
