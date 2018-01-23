package com.liberate.automation.testcases;

import com.liberate.automation.common.CommonData;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CPNewCustomer;

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
}
