package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.BadCheckProcessing;

public class BadCheckProcessing_tc {

	static TestActions action = CommonLogin.action;
	
	@Test
	public void NewBadCheckProcessing() {
		BadCheckProcessing bcp = new BadCheckProcessing(action);

		assertEquals(bcp.navigate(), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.PaymentNumber("9318230"), true);
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
		assertEquals(bcp.PaymentItemAcceptButton(), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.CheckDetailsDropdown("3"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.CheckDetailsAccept(), true);
		action.getScreenShot("BadCheckProcessing");
	}

	public void NewBadCheckProcessingReset() {
		BadCheckProcessing bcp = new BadCheckProcessing(action);

		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.navigate(), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.PaymentNumber("9318234"), true);
		action.getScreenShot("BadCheckProcessing");
		assertEquals(bcp.Reset(), true);
		action.getScreenShot("BadCheckProcessing");

	}

	public void NewBadCheckProcessingCancel() {

		BadCheckProcessing bcp = new BadCheckProcessing(action);

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
		assertEquals(bcp.CurrentCreditCancelButton(), true);
		action.getScreenShot("BadCheckProcessing");
	}
}