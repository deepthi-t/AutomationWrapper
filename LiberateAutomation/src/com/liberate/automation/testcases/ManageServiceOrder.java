package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.MSOAddRemoveServiceCharge;
import com.liberate.automation.pom.MSOAddSpecialInstructions;
import com.liberate.automation.pom.MSOEnquiry;

public class ManageServiceOrder {
	static TestActions action = CommonLogin.action;
	
	@Test
	public void addSpecialInstructions()
	{
		MSOAddSpecialInstructions mso = new MSOAddSpecialInstructions(action);
		MSOEnquiry mse = new MSOEnquiry(action);
		
		String serviceOrderNumber = "TK00144";
		
		action.getScreenShot("addSpecialInstructions");
		mso.navigate();
		action.getScreenShot("addSpecialInstructions");
		mso.searchSearviceOrder(serviceOrderNumber);
		action.getScreenShot("addSpecialInstructions");
		mso.verifyServiceOrderDetails();
		action.getScreenShot("addSpecialInstructions");
		mso.addSpecialInstruction();
		action.getScreenShot("addSpecialInstructions");
		mso.clickOnOKpopup();
		action.getScreenShot("addSpecialInstructions");
		
		mse.navigate();
		action.getScreenShot("addSpecialInstructions");
		mse.searchServiceOrder(serviceOrderNumber);
		action.getScreenShot("addSpecialInstructions");
		mse.verifyServiceOrderDetails(serviceOrderNumber);
		action.getScreenShot("addSpecialInstructions");
		mse.verifySepcialInstructions(mso.SpecialInstruction);
		action.getScreenShot("addSpecialInstructions");
	}
	
	@Test
	public void addServiceCharge()
	{
		MSOAddRemoveServiceCharge msr = new MSOAddRemoveServiceCharge(action);
		String serviceOrderNumber = "TK00144";

		msr.navigate();
		msr.searchByServiceOrder("RSNET", serviceOrderNumber);
		msr.verifyServiceOrderDetails();
		msr.addServiceCharge();
		msr.verifyServiceCharge(msr.ServiceCharge, true);
	}

	@Test
	public void removeServiceCharge()
	{
		MSOAddRemoveServiceCharge msr = new MSOAddRemoveServiceCharge(action);
		String serviceOrderNumber = "TK00144";

		msr.navigate();
		msr.searchByServiceOrder("RSNET", serviceOrderNumber);
		msr.verifyServiceOrderDetails();
		msr.deleteServiceCharge();
		msr.verifyServiceCharge(msr.ServiceCharge, false);
	}
}
