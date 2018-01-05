package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.MSOAddRemoveServiceCharge;
import com.liberate.automation.pom.MSOAddSpecialInstructions;
import com.liberate.automation.pom.MSOCancelServiceOrder;
import com.liberate.automation.pom.MSOEnquiry;
import com.liberate.automation.pom.MSOManualWaitlistRelease;
import com.liberate.automation.pom.MSOReject;
import com.liberate.automation.pom.MSORelease;
import com.liberate.automation.pom.MSOSignoff;
import com.liberate.automation.pom.MSOWaitlist;

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
	
	@Test
	public void cancelServiceOrder()
	{
		MSOCancelServiceOrder msc = new MSOCancelServiceOrder(action);
		MSOEnquiry mse = new MSOEnquiry(action);
		
		msc.navigate();
		msc.searchSearviceOrder("", "");
		msc.verifyServiceOrdeDetails(msc.ServiceOrderNumber);
		msc.cancelServiceOrder();
		msc.clickOnOKButton();
		
		mse.navigate();
		mse.searchServiceOrder(msc.ServiceOrderNumber);
		mse.verifyDepartmentCirculation();
		mse.getCurrentServiceOrderStatus();
	}
	
	@Test
	public void generalSignOffServiceOrder()
	{
		MSOSignoff mss = new MSOSignoff(action);
		
		mss.navigate();
		mss.searchSearviceOrder("BGINS", "TB00196");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		mss.generalSignOff();
	}
	
	@Test
	public void accountSignOffServiceOrder()
	{
		MSOSignoff mss = new MSOSignoff(action);
		
		mss.navigate();
		mss.searchSearviceOrder("AQSOF", "ZE00240");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		mss.accountSignOff();
	}
	
	@Test
	public void rejectServiceOrder()
	{
		MSOReject mss = new MSOReject(action);
		
		mss.navigate();
		mss.searchSearviceOrder("AQSOF", "YD00484");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		mss.reject();
	}
	
	@Test
	public void releaseServiceOrder()
	{
		MSORelease mss = new MSORelease(action);
		
		mss.navigate();
		mss.searchSearviceOrder("AQSOF", "A00173B");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		mss.releaseServiceOrder();
	}
	
	@Test
	public void waitlistServiceOrder()
	{
		MSOWaitlist mss = new MSOWaitlist(action);
		
		mss.navigate();
		mss.searchSearviceOrder("AQSOF", "A00173B");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		mss.waitlistServiceOrder();
	}
	
	@Test
	public void manualWaitlistReleaseServiceOrder()
	{
		MSOManualWaitlistRelease mss = new MSOManualWaitlistRelease(action);
		
		mss.navigate();
		mss.searchSearviceOrder("AQSOF", "A00173B");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		mss.manualWaitlistRelease();
	}
}
