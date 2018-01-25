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
	
	public void existingCustomerPCLPostpaid() {
		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);

		ce.navigate();
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.searchWithAccount("280000710000");
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.selectServicePackage("PCL", "LIME_POST");
//		ce.selectServicePackage("PCL", "SOW-");
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.processPricingPlanScreen();
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.processServiceProductsScreen();
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.processProductFieldsScreen();
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.processISPFieldsScreen();
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.provideContractDetails();
		action.getScreenShot("existingCustomerPCLPostpaid");

		sso.verifySalesSignOff();
		action.getScreenShot("existingCustomerPCLPostpaid");
		sso.signOff();
		action.getScreenShot("existingCustomerPCLPostpaid");

		cso.getSONumber();
		action.getScreenShot("existingCustomerPCLPostpaid");
		cso.getSOCommand();
		action.getScreenShot("existingCustomerPCLPostpaid");
	}
	
	public void newCustomerPCLPostpaid() {
		CPNewCustomer cp = new CPNewCustomer(action);
		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);
		
		cp.navigate();
		action.getScreenShot("newCustomerPEL");
		cp.fillApplicationDetails(CommonData.ApplicationForm.MobilepostpaidResidential, CommonData.CustomerType.Residential,
				"PCL", "LIME_POST");
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
		
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.selectServicePackage("PCL", "SOW-");
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.processPricingPlanScreen();
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.processServiceProductsScreen();
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.processProductFieldsScreen();
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.processISPFieldsScreen();
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.provideContractDetails();
		action.getScreenShot("existingCustomerPCLPostpaid");

		sso.verifySalesSignOff();
		action.getScreenShot("existingCustomerPCLPostpaid");
		sso.signOff();
		action.getScreenShot("existingCustomerPCLPostpaid");

		cso.getSONumber();
		action.getScreenShot("existingCustomerPCLPostpaid");
		cso.getSOCommand();
		action.getScreenShot("existingCustomerPCLPostpaid");
	}
	
	public void newCustomerPCLCreditLimit() {
		CPNewCustomer cp = new CPNewCustomer(action);
		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);
		
		cp.navigate();
		action.getScreenShot("newCustomerPEL");
		cp.fillApplicationDetails(CommonData.ApplicationForm.MobilepostpaidResidential, CommonData.CustomerType.Residential,
				"PCL", "SOW-");
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
		
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.selectServicePackage("PCL", "SOW-");
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.processPricingPlanScreen();
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.processServiceProductsScreen();
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.processProductFieldsScreen();
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.processISPFieldsScreen();
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot("existingCustomerPCLPostpaid");
		ce.provideContractDetails();
		action.getScreenShot("existingCustomerPCLPostpaid");

		sso.verifySalesSignOff();
		action.getScreenShot("existingCustomerPCLPostpaid");
		sso.signOff();
		action.getScreenShot("existingCustomerPCLPostpaid");

		cso.getSONumber();
		action.getScreenShot("existingCustomerPCLPostpaid");
		cso.getSOCommand();
		action.getScreenShot("existingCustomerPCLPostpaid");
	}
	
	public void existingCustomerPDL() {
		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);

		ce.navigate();
		action.getScreenShot("existingCustomerPDL");
		ce.searchWithAccount("280000710000");
		action.getScreenShot("existingCustomerPDL");
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot("existingCustomerPDL");
		ce.selectServicePackage("PDL", "ADSL_PACK");
		action.getScreenShot("existingCustomerPDL");
		ce.processPricingPlanScreen();
		action.getScreenShot("existingCustomerPDL");
		ce.processServiceProductsScreen();
		action.getScreenShot("existingCustomerPDL");
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot("existingCustomerPDL");
		ce.provideContractDetails();
		action.getScreenShot("existingCustomerPDL");

		sso.verifySalesSignOff();
		action.getScreenShot("existingCustomerPDL");
		sso.signOff();
		action.getScreenShot("existingCustomerPDL");

		cso.getSONumber();
		action.getScreenShot("existingCustomerPDL");
		cso.getSOCommand();
		action.getScreenShot("existingCustomerPDL");
	}

	public void newCustomerPELandPDL() {
		CPNewCustomer cp = new CPNewCustomer(action);
		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);

		cp.navigate();
		action.getScreenShot("newCustomerPELandPDL");
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,
				"PEL", "ETFT");
		action.getScreenShot("newCustomerPELandPDL");

		cp.fillResidentialCustomerDetails();
		action.getScreenShot("newCustomerPELandPDL");
		cp.fillStandardAddress();
		action.getScreenShot("newCustomerPELandPDL");
		cp.fillCustomerClassification();
		action.getScreenShot("newCustomerPELandPDL");
		cp.fillBillingDetails();
		action.getScreenShot("newCustomerPELandPDL");
		cp.fillCustomerID();
		action.getScreenShot("newCustomerPELandPDL");
		cp.fillContactDetails();
		action.getScreenShot("newCustomerPELandPDL");
		cp.verifyCreatedAccount();

		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot("newCustomerPELandPDL");
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot("newCustomerPELandPDL");
		ce.processPricingPlanScreen();
		action.getScreenShot("newCustomerPELandPDL");
		ce.processServiceProductsScreen();
		action.getScreenShot("newCustomerPELandPDL");
		ce.processProductFieldsScreen();
		action.getScreenShot("newCustomerPELandPDL");
		ce.processISPFieldsScreen();
		action.getScreenShot("newCustomerPELandPDL");
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot("newCustomerPELandPDL");
		ce.provideContractDetails();
		action.getScreenShot("newCustomerPELandPDL");
		ce.provideADSL();
		action.getScreenShot("newCustomerPELandPDL");
		
		//PDL Part
		ce.selectServicePackage("PDL", "ADSL_PACK");
		action.getScreenShot("existingCustomerPDL");
		ce.processPricingPlanScreen();
		action.getScreenShot("existingCustomerPDL");
		ce.processServiceProductsScreen();
		action.getScreenShot("existingCustomerPDL");
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot("existingCustomerPDL");
		ce.provideContractDetails();
		action.getScreenShot("existingCustomerPDL");

		sso.verifySalesSignOff();
		action.getScreenShot("existingCustomerPDL");
		sso.signOff();
		action.getScreenShot("existingCustomerPDL");

		cso.getSONumber();
		action.getScreenShot("existingCustomerPDL");
		cso.getSOCommand();
		action.getScreenShot("existingCustomerPDL");
	}

	public void addMorePELandPDL() {
		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);
		AddMore addmore = new AddMore(action);

		ce.navigate();
		action.getScreenShot("addMorePELandPDL");
		ce.searchWithAccount("280000710000");
		action.getScreenShot("addMorePELandPDL");
		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot("addMorePELandPDL");
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot("addMorePELandPDL");
		ce.processPricingPlanScreen();
		action.getScreenShot("addMorePELandPDL");
		ce.processServiceProductsScreen();
		action.getScreenShot("addMorePELandPDL");
		ce.processProductFieldsScreen();
		action.getScreenShot("addMorePELandPDL");
		ce.processISPFieldsScreen();
		action.getScreenShot("addMorePELandPDL");
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot("addMorePELandPDL");
		ce.provideContractDetails();
		action.getScreenShot("addMorePELandPDL");
		ce.skipADSL();
		action.getScreenShot("addMorePELandPDL");

		sso.verifySalesSignOff();
		action.getScreenShot("addMorePELandPDL");
		sso.addMore();
		action.getScreenShot("addMorePELandPDL");
		
		addmore.addADSL();
		action.getScreenShot("addMorePELandPDL");
		
		//PDL Part
		ce.selectServicePackage("PDL", "ADSL_PACK");
		action.getScreenShot("addMorePELandPDL");
		ce.processPricingPlanScreen();
		action.getScreenShot("addMorePELandPDL");
		ce.processServiceProductsScreen();
		action.getScreenShot("addMorePELandPDL");
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot("addMorePELandPDL");
		ce.provideContractDetails();
		action.getScreenShot("addMorePELandPDL");

		sso.verifySalesSignOff();
		action.getScreenShot("addMorePELandPDL");
		sso.signOff();
		action.getScreenShot("addMorePELandPDL");

		cso.getSONumber();
		action.getScreenShot("addMorePELandPDL");
		cso.getSOCommand();
		action.getScreenShot("addMorePELandPDL");
	}

	
	public void addMorePELandPCL() {
		CPExistingCustomer ce = new CPExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CRServiceOrder cso = new CRServiceOrder(action);
		AddMore addmore = new AddMore(action);
		
		ce.navigate();
		action.getScreenShot("addMorePELandPCL");
		ce.searchWithAccount("280000710000");
		action.getScreenShot("addMorePELandPCL");
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot("addMorePELandPCL");
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot("addMorePELandPCL");
		ce.processPricingPlanScreen();
		action.getScreenShot("addMorePELandPCL");
		ce.processServiceProductsScreen();
		action.getScreenShot("addMorePELandPCL");
		ce.processProductFieldsScreen();
		action.getScreenShot("addMorePELandPCL");
		ce.processISPFieldsScreen();
		action.getScreenShot("addMorePELandPCL");
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot("addMorePELandPCL");
		ce.provideContractDetails();
		action.getScreenShot("addMorePELandPCL");
		ce.skipADSL();
		action.getScreenShot("addMorePELandPCL");

		sso.verifySalesSignOff();
		action.getScreenShot("addMorePELandPCL");
		sso.addMore();
		action.getScreenShot("addMorePELandPCL");
		
		addmore.addServicePackage();
		action.getScreenShot("addMorePELandPCL");
		
		action.getScreenShot("addMorePELandPCL");
		ce.selectServicePackage("PCL", "LIME_POST");
//		ce.selectServicePackage("PCL", "SOW-");
		action.getScreenShot("addMorePELandPCL");
		ce.processPricingPlanScreen();
		action.getScreenShot("addMorePELandPCL");
		ce.processServiceProductsScreen();
		action.getScreenShot("addMorePELandPCL");
		ce.processProductFieldsScreen();
		action.getScreenShot("addMorePELandPCL");
		ce.processISPFieldsScreen();
		action.getScreenShot("addMorePELandPCL");
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot("addMorePELandPCL");
		ce.provideContractDetails();
		action.getScreenShot("addMorePELandPCL");

		sso.verifySalesSignOff();
		action.getScreenShot("addMorePELandPCL");
		sso.signOff();
		action.getScreenShot("addMorePELandPCL");

		cso.getSONumber();
		action.getScreenShot("addMorePELandPCL");
		cso.getSOCommand();
		action.getScreenShot("addMorePELandPCL");
	}
}
