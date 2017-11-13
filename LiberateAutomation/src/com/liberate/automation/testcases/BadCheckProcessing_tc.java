package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.BadCheckProcessing;
import com.liberate.automation.pom.Login;

public class BadCheckProcessing_tc {

	TestActions action = null;

	public BadCheckProcessing_tc(TestActions action) {
		// TODO Auto-generated constructor stub
		this.action = action;
	}

	public void navigateToURL() {
		action.gotoURL("http://172.21.73.80:8081/liberate-LONI01-S10/");
	}

	public void NewBadCheckProcessing() {
		BadCheckProcessing bcp = new BadCheckProcessing(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.navigate(), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.PaymentNumber(" 9318230"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.Search(), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.Checkdetailsbutton(), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.Checkcardinput("53453453453453453453"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.ReasonDropDown("3"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.CurrentCreditApportionData("20"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.CurrentCreditAcceptButton(), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.PaymentItemAcceptButton(),true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.CheckDetailsDropdown("3"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.CheckDetailsAccept(), true);
		action.getScreenShot("BadCheckProcessing");
	}

	public void NewBadCheckProcessingReset() {
		BadCheckProcessing bcp = new BadCheckProcessing(action);
		Login login = new Login(action);
		assertEquals(login.login("libadmin", "Ic3cr34m!"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.navigate(), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.PaymentNumber("9318234"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.Reset(),true);
		action.getScreenShot("BadCheckProcessing");
		
		
}
	
	
	public void NewBadCheckProcessingCancel() {
	
		BadCheckProcessing bcp = new BadCheckProcessing(action);
		Login login = new Login(action);
		
		assertEquals(login.login("libadmin", "Ic3cr34m!"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.navigate(), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.PaymentNumber("9318234"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.Search(), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.Checkdetailsbutton(), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.Checkcardinput("53453453453453453453"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.ReasonDropDown("3-REFER TO PAYER"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.CurrentCreditApportionData("10"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.CurrentCreditCancelButton(),true);
		action.getScreenShot("BadCheckProcessing");
	}
}